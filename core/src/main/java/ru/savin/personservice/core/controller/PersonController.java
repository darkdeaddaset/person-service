package ru.savin.personservice.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.model.Person;
import ru.savin.personservice.core.service.PersonService;
import ru.savin.personservice.dto.PersonDTO;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable("id") long id) {
        return personService.getId(id);
    }

   /* @GetMapping("/{lastName}")
    public Person get(@PathVariable("lastName") String lastname) {
        return personService.getAll(lastname);
    }*/

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody PersonDTO personDTO) {
        return personService.update(personDTO);
    }
}
