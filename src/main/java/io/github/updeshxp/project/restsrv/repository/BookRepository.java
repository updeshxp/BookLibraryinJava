package io.github.updeshxp.project.restsrv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.updeshxp.project.restsrv.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	boolean existsByIsbnIgnoreCase(String isbn);

	boolean existsByIsbnIgnoreCaseAndIdNot(String isbn, Long id);

	boolean existsByTitleIgnoreCaseAndAuthorIgnoreCase(String title, String author);

	boolean existsByTitleIgnoreCaseAndAuthorIgnoreCaseAndIdNot(String title, String author, Long id);
}
