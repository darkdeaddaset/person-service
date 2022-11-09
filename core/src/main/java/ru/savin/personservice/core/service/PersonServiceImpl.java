package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.PersonMapper;
import ru.savin.personservice.core.model.Person;
import ru.savin.personservice.core.repository.PersonRepository;
import ru.savin.personservice.dto.PersonDTO;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @Override
    public ResponseEntity save(PersonDTO personDTO) {
        return Optional.of(personDTO)
                .map(personMapper::getFromDTO)
                .map(x -> {
                    if (personDTO.getFirstName().isEmpty() || personDTO.getFirstName().isBlank()) {
                        log.error("Данные о клиенте пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    personRepository.save(x);
                    return new ResponseEntity("Данные о клиенте внесены", HttpStatus.OK);})
                .orElseThrow(() -> new EntityNotFoundException("Нельзя создать данные о клиенте"));
    }

    @Override
    public ResponseEntity update(PersonDTO personDTO) {
        return personRepository.getPersonByLastNameAndFirstName(personDTO.getLastName(), personDTO.getFirstName())
                .map(update -> {
                    if (personDTO.getFirstName().isBlank() || personDTO.getFirstName().isEmpty() &&
                    personDTO.getLastName().isBlank() || personDTO.getLastName().isEmpty()) {
                        log.error("Данные пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    Person person = personMapper.getFromDTO(personDTO);
                    personRepository.save(person);
                    return ResponseEntity.ok(personMapper.getFromModel(person));})
                .orElseThrow(() -> new EntityNotFoundException("Невозможно обновить данные адреса"));
    }

    @Override
    public Person getAll(String lastName) {
        return personRepository.getPersonByLastName(lastName)
                .orElseThrow();
    }

    @Override
    public PersonDTO getId(long id) {
        return personRepository.getPersonById(id)
                .map(personMapper::getFromModel)
                .orElseThrow();
    }
}
