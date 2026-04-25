package io.github.updeshxp.project.restsrv.controller;

import io.github.updeshxp.project.restsrv.dto.BookDto;
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
	public List<BookDto> getAllBooks() {
		return bookService.getAllBooks()
				.stream()
				.map(BookDto::from)
				.toList();
	}

	@GetMapping("/{id}")
	public BookDto getBookById(@PathVariable Long id) {
		return BookDto.from(bookService.getBookById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDto createBook(@Valid @RequestBody BookDto request) {
		return BookDto.from(bookService.createBook(request));
	}

	@PutMapping("/{id}")
	public BookDto updateBook(@PathVariable Long id, @Valid @RequestBody BookDto request) {
		return BookDto.from(bookService.updateBook(id, request));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}
}
