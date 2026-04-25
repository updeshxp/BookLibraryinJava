package io.github.updeshxp.project.restsrv.dto;

import java.time.Year;

import io.github.updeshxp.project.restsrv.entity.Book;

public class BookResponse {

	private Long id;
	private String title;
	private String author;
	private String isbn;
	private Year publishedYear;
	private Integer availableCopies;

	public static BookResponse from(Book book) {
		BookResponse response = new BookResponse();
		response.setId(book.getId());
		response.setTitle(book.getTitle());
		response.setAuthor(book.getAuthor());
		response.setIsbn(book.getIsbn());
		response.setPublishedYear(book.getPublishedYear());
		response.setAvailableCopies(book.getAvailableCopies());
		return response;
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
