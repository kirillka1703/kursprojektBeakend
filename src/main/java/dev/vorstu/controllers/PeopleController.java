package dev.vorstu.controllers;

import dev.vorstu.dto.PeopleDTO;
import dev.vorstu.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public ResponseEntity<List<PeopleDTO>> getAllPeople() {
        List<PeopleDTO> peopleDTOList = peopleService.getAllPeople();
        return ResponseEntity.ok(peopleDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleDTO> getPeopleById(@PathVariable("id") Long id) {
        Optional<PeopleDTO> peopleDTOOptional = peopleService.getPeopleById(id);
        return peopleDTOOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PeopleDTO> createPerson(@RequestBody PeopleDTO personDTO) {
        PeopleDTO createdPersonDTO = peopleService.createPerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersonDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
        peopleService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeopleDTO> updatePerson(@PathVariable("id") Long id, @RequestBody PeopleDTO personDTO) {
        if (peopleService.getPeopleById(id).isPresent()) {
            Optional<PeopleDTO> updatedPersonDTOOptional = peopleService.updatePerson(id, personDTO);
            return updatedPersonDTOOptional
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}