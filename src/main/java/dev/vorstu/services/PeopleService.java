package dev.vorstu.services;

import dev.vorstu.dto.PeopleDTO;
import dev.vorstu.entity.People;
import dev.vorstu.repositories.PeopleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleDTO> getAllPeople() {
        List<People> peopleList = (List<People>) peopleRepository.findAll();
        return peopleList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<PeopleDTO> getPeopleById(Long id) {
        Optional<People> peopleOptional = peopleRepository.findById(id);
        return peopleOptional.map(this::convertToDto);
    }

    public PeopleDTO createPerson(PeopleDTO personDTO) {
        People person = convertToEntity(personDTO);
        People savedPerson = peopleRepository.save(person);
        return convertToDto(savedPerson);
    }

    private PeopleDTO convertToDto(People people) {
        PeopleDTO peopleDTO = new PeopleDTO();
        BeanUtils.copyProperties(people, peopleDTO);
        return peopleDTO;
    }

    private People convertToEntity(PeopleDTO peopleDTO) {
        People people = new People();
        BeanUtils.copyProperties(peopleDTO, people);
        return people;
    }

    public void deletePerson(Long id) {
        if (peopleRepository.existsById(id)) {
            peopleRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Person with ID " + id + " does not exist");
        }
    }

    public Optional<PeopleDTO> updatePerson(Long id, PeopleDTO personDTO) {
        Optional<People> personOptional = peopleRepository.findById(id);
        if (personOptional.isPresent()) {
            People person = personOptional.get();
            person.setPeopleName(personDTO.getPeopleName());
            person.setFirstName(personDTO.getFirstName());
            People updatedPerson = peopleRepository.save(person);
            return Optional.of(convertToDto(updatedPerson));
        } else {
            return Optional.empty();
        }
    }
}