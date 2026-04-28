package io.github.updeshxp.project.restsrv.service;

import io.github.updeshxp.project.restsrv.dto.BookDto;
import io.github.updeshxp.project.restsrv.entity.Book;
import io.github.updeshxp.project.restsrv.exception.ConflictException;
import io.github.updeshxp.project.restsrv.exception.ResourceNotFoundException;
import io.github.updeshxp.project.restsrv.repository.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional(readOnly = true)
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Book getBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
	}

	@Transactional
	public Book createBook(BookDto request) {
		validateUniqueness(request.getTitle(), request.getAuthor(), request.getIsbn(), null);

		Book book = new Book();
		mapRequestToBook(request, book);
		return bookRepository.save(book);
	}

	@Transactional
	public Book updateBook(Long id, BookDto request) {
		Book existing = getBookById(id);
		validateUniqueness(request.getTitle(), request.getAuthor(), request.getIsbn(), id);

		mapRequestToBook(request, existing);
		return bookRepository.save(existing);
	}

	@Transactional
	public void deleteBook(Long id) {
		Book existing = getBookById(id);
		bookRepository.delete(existing);
	}

	private void validateUniqueness(String title, String author, String isbn, Long bookIdToExclude) {
		if (bookIdToExclude == null) {
			if (bookRepository.existsByIsbnIgnoreCase(isbn)) {
				throw new ConflictException("A book already exists with ISBN: " + isbn);
			}
			if (bookRepository.existsByTitleIgnoreCaseAndAuthorIgnoreCase(title, author)) {
				throw new ConflictException("A book already exists with same title and author");
			}
			return;
		}

		if (bookRepository.existsByIsbnIgnoreCaseAndIdNot(isbn, bookIdToExclude)) {
			throw new ConflictException("A book already exists with ISBN: " + isbn);
		}
		if (bookRepository.existsByTitleIgnoreCaseAndAuthorIgnoreCaseAndIdNot(title, author, bookIdToExclude)) {
			throw new ConflictException("A book already exists with same title and author");
		}
	}

	private void mapRequestToBook(BookDto request, Book book) {
		book.setTitle(request.getTitle().trim());
		book.setAuthor(request.getAuthor().trim());
		book.setIsbn(request.getIsbn().trim());
		book.setPublishedYear(request.getPublishedYear());
		book.setReviewPublished(request.getReviewPublished());
		book.setAvailableCopies(request.getAvailableCopies());
	}
}
