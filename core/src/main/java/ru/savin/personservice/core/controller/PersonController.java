package ru.savin.personservice.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.model.Person;
import ru.savin.personservice.core.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping(value = "/all")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @PostMapping(value = "/add")
    public Person add(@RequestBody Person person) {
        return personService.add(person);
    }
}
