package io.github.updeshxp.project.restsrv.dto;

import java.time.Year;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class BookRequest {

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
