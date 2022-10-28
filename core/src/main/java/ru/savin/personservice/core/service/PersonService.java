package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.PersonMapper;
import ru.savin.personservice.core.model.Person;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonMapper personMapper;

    public List<Person> getAll() {
        return personMapper.getAllPersons();
    }

    public Person add(Person person) {
        return personMapper.addPerson(person);
    }
}
