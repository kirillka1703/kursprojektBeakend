package dev.vorstu.controllers;

import dev.vorstu.dto.DateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vorstu.services.DateService;

import java.util.List;
import java.util.stream.Collectors;

import dev.vorstu.entity.EventDate;
@RestController
@RequestMapping("/api/dates")
public class DateController {

    private final DateService dateService;

    @Autowired
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping
    public List<DateDTO> getAllDates() {
        List<EventDate> eventDates = dateService.getAllDates();
        return eventDates.stream()
                .map(eventDate -> {
                    DateDTO dateDTO = new DateDTO();
                    dateDTO.setId(eventDate.getId());
                    dateDTO.setDate(eventDate.getEventDate());
                    return dateDTO;
                })
                .collect(Collectors.toList());
    }
}