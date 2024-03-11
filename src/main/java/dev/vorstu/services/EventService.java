package dev.vorstu.services;

import dev.vorstu.entity.Event;
import dev.vorstu.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Long getEventCountByPeopleName(String peopleName) {
        return Long.valueOf(eventRepository.countByPeopleName(peopleName));
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }
}