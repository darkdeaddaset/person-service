package ru.savin.personservice.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.mapper.ContactMapper;
import ru.savin.personservice.core.model.Contact;

import java.util.List;

@RestController
@RequestMapping("/contact")
@AllArgsConstructor
public class ContactController {
    private ContactMapper contactMapper;

    @GetMapping("/all")
    public List<Contact> getAll() {
        return contactMapper.getAll();
    }
}
