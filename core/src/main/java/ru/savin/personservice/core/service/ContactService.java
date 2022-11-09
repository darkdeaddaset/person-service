package ru.savin.personservice.core.service;

import org.springframework.http.ResponseEntity;
import ru.savin.personservice.core.model.Contact;
import ru.savin.personservice.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    ResponseEntity<String> save(ContactDTO contactDTO);
    ResponseEntity update(ContactDTO contactDTO);
    ResponseEntity getAll(String email);
}
