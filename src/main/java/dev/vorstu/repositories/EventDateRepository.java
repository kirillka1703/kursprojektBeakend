package dev.vorstu.repositories;

import dev.vorstu.entity.EventDate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDateRepository extends CrudRepository<EventDate, Long> {
}