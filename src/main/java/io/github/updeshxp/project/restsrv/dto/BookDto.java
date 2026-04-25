package io.github.updeshxp.project.restsrv.dto;

import java.time.Year;

import io.github.updeshxp.project.restsrv.entity.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BookDto {

	private Long id;

	@NotBlank(message = "Title is required")
	@Size(max = 150, message = "Title must be at most 150 characters")
	private String title;

	@NotBlank(message = "Author is required")
	@Size(max = 100, message = "Author must be at most 100 characters")
	private String author;

	@NotBlank(message = "ISBN is required")
	@Size(min = 10, max = 20, message = "ISBN must be between 10 and 20 characters")
	@Pattern(regexp = "^[0-9Xx-]+$", message = "ISBN may only contain digits, X and hyphen")
	private String isbn;

	@NotNull(message = "Published year is required")
	@Past(message = "Published year should be in the past")
	private Year publishedYear;

	@NotNull(message = "Available copies are required")
	@Min(value = 0, message = "Available copies cannot be negative")
	private Integer availableCopies;

	public static BookDto from(Book book) {
		BookDto dto = new BookDto();
		dto.setId(book.getId());
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setIsbn(book.getIsbn());
		dto.setPublishedYear(book.getPublishedYear());
		dto.setAvailableCopies(book.getAvailableCopies());
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Year getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(Year publishedYear) {
		this.publishedYear = publishedYear;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}
}