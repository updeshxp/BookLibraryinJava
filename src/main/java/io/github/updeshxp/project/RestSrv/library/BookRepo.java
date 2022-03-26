package io.github.updeshxp.project.RestSrv.library;

import io.github.updeshxp.project.RestSrv.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
}
