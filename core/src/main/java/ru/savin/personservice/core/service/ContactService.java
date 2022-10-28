package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.ContactMapper;
import ru.savin.personservice.core.model.Contact;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {
    private ContactMapper contactMapper;

    public List<Contact> getAll() {
        return contactMapper.getAll();
    }
}
