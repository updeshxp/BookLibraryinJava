package io.github.updeshxp.project.restsrv.controller;

import io.github.updeshxp.project.restsrv.dto.BookRequest;
import io.github.updeshxp.project.restsrv.dto.BookResponse;
import io.github.updeshxp.project.restsrv.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public List<BookResponse> getAllBooks() {
		return bookService.getAllBooks()
				.stream()
				.map(BookResponse::from)
				.toList();
	}

	@GetMapping("/{id}")
	public BookResponse getBookById(@PathVariable Long id) {
		return BookResponse.from(bookService.getBookById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookResponse createBook(@Valid @RequestBody BookRequest request) {
		return BookResponse.from(bookService.createBook(request));
	}

	@PutMapping("/{id}")
	public BookResponse updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
		return BookResponse.from(bookService.updateBook(id, request));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}
}
