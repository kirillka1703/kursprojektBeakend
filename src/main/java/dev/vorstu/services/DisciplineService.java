package dev.vorstu.services;

import dev.vorstu.dto.DisciplineDTO;
import dev.vorstu.entity.Discipline;
import dev.vorstu.repositories.DisciplineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<DisciplineDTO> getAllDisciplines() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        return disciplines.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<DisciplineDTO> getDisciplineById(Long id) {
        Optional<Discipline> disciplineOptional = disciplineRepository.findById(id);
        return disciplineOptional.map(this::convertToDto);
    }

    public DisciplineDTO createDiscipline(DisciplineDTO disciplineDTO) {
        Discipline discipline = convertToEntity(disciplineDTO);
        Discipline savedDiscipline = disciplineRepository.save(discipline);
        return convertToDto(savedDiscipline);
    }

    public DisciplineDTO updateDiscipline(Long id, DisciplineDTO disciplineDTO) {
        Optional<Discipline> existingDisciplineOptional = disciplineRepository.findById(id);
        existingDisciplineOptional.ifPresent(existingDiscipline -> {
            Discipline updatedDiscipline = convertToEntity(disciplineDTO);
            updatedDiscipline.setId(existingDiscipline.getId());
            disciplineRepository.save(updatedDiscipline);
        });
        return existingDisciplineOptional.map(this::convertToDto).orElse(null);
    }

    public void deleteDiscipline(Long id) {
        disciplineRepository.deleteById(id);
    }

    private DisciplineDTO convertToDto(Discipline discipline) {
        DisciplineDTO disciplineDTO = new DisciplineDTO();
        BeanUtils.copyProperties(discipline, disciplineDTO);
        return disciplineDTO;
    }

    private Discipline convertToEntity(DisciplineDTO disciplineDTO) {
        Discipline discipline = new Discipline();
        BeanUtils.copyProperties(disciplineDTO, discipline);
        return discipline;
    }
}