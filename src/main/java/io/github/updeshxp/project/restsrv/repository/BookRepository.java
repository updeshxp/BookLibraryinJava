package io.github.updeshxp.project.restsrv.repository;

import io.github.updeshxp.project.restsrv.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
