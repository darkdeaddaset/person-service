package ru.savin.personservice.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.model.Contact;
import ru.savin.personservice.core.service.ContactService;
import ru.savin.personservice.dto.ContactDTO;

import java.util.List;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {
    private ContactService contactService;

    @GetMapping("/{email}")
    public ResponseEntity getAll(@PathVariable("email") String email) {
        return contactService.getAll(email);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ContactDTO contactDTO) {
        return contactService.save(contactDTO);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ContactDTO contactDTO) {
        return contactService.update(contactDTO);
    }
}
