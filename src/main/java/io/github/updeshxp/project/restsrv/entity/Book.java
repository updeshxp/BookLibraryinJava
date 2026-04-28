package io.github.updeshxp.project.restsrv.entity;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
		name = "books",
		uniqueConstraints = {
				@UniqueConstraint(name = "uk_book_isbn", columnNames = "isbn"),
				@UniqueConstraint(name = "uk_book_title_author", columnNames = {"title", "author"})
		}
)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String title;

	@Column(nullable = false, length = 100)
	private String author;

	@Column(nullable = false, length = 20)
	private String isbn;

	@Column(nullable = false)
	private Year publishedYear;

	@Column(nullable = false)
	private Integer availableCopies;

	@Column()
	private String description;

	@Column(nullable = false)
	private Boolean isReviewPublished;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Boolean getReviewPublished() {
		return isReviewPublished;
	}

	public void setReviewPublished(boolean isReviewPublished) {
		this.isReviewPublished = isReviewPublished;
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
