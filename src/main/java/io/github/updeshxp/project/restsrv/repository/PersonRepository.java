package io.github.updeshxp.project.restsrv.repository;

import io.github.updeshxp.project.restsrv.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
