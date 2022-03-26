package io.github.updeshxp.project.RestSrv.library;

import io.github.updeshxp.project.RestSrv.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
}
