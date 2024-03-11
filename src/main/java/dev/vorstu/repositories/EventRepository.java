package dev.vorstu.repositories;

import dev.vorstu.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    int countByPeopleName(String peopleName);

}