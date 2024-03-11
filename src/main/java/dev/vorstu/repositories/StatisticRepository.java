package dev.vorstu.repositories;

import dev.vorstu.entity.Statistic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Long> {
    @Query("SELECT s, COUNT(e.id) FROM Statistic s LEFT JOIN Event e ON s.peopleName = e.peopleName GROUP BY s.id")
    List<Object[]> getAllStatistics();
}