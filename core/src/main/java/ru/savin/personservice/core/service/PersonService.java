package ru.savin.personservice.core.service;

import org.springframework.http.ResponseEntity;
import ru.savin.personservice.core.model.Person;
import ru.savin.personservice.dto.PersonDTO;

public interface PersonService {
    ResponseEntity save(PersonDTO personDTO);
    ResponseEntity update(PersonDTO personDTO);
    Person getAll(String lastName);
    PersonDTO getId(long id);
}
