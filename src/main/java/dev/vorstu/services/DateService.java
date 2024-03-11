package dev.vorstu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.vorstu.entity.EventDate;
import dev.vorstu.repositories.EventDateRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DateService {
    private final EventDateRepository dateRepository;

    @Autowired
    public DateService(EventDateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    public List<EventDate> getAllDates() {
        Iterable<EventDate> iterable = dateRepository.findAll();
        List<EventDate> dates = new ArrayList<>();
        iterable.forEach(dates::add);
        return dates;
    }
}