package dev.vorstu.repositories;

import dev.vorstu.entity.People;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long> {

}
