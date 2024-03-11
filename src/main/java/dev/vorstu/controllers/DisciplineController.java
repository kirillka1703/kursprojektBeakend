package dev.vorstu.controllers;


import dev.vorstu.dto.DisciplineDTO;
import dev.vorstu.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }
    @GetMapping
    public ResponseEntity<List<DisciplineDTO>> getAllDisciplines() {
        List<DisciplineDTO> disciplines = disciplineService.getAllDisciplines();
        return ResponseEntity.ok(disciplines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDTO> getDisciplineById(@PathVariable Long id) {
        Optional<DisciplineDTO> disciplineOptional = disciplineService.getDisciplineById(id);
        return disciplineOptional
                .map(discipline -> ResponseEntity.ok().body(discipline))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisciplineDTO> createDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        DisciplineDTO createdDiscipline = disciplineService.createDiscipline(disciplineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscipline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplineDTO> updateDiscipline(
            @PathVariable Long id,
            @RequestBody DisciplineDTO disciplineDTO
    ) {
        DisciplineDTO updatedDiscipline = disciplineService.updateDiscipline(id, disciplineDTO);
        return ResponseEntity.ok(updatedDiscipline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable Long id) {
        disciplineService.deleteDiscipline(id);
        return ResponseEntity.noContent().build();
    }

}
