package dev.vorstu.controllers;

import dev.vorstu.dto.DisciplineDTO;
import dev.vorstu.dto.EventDTO;
import dev.vorstu.entity.Event;
import dev.vorstu.services.DisciplineService;
import dev.vorstu.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/new-calendar")
public class EventController {

    private EventService eventService;
    private DisciplineService disciplineService;
    @Autowired
    public EventController(EventService eventService) { this.eventService = eventService; }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/events")
     public Event createEvent(@RequestBody Event event) {
         return eventService.createEvent(event);
     }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event deleted successfully");
    }



}