package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.ContactMapper;
import ru.savin.personservice.core.model.Contact;
import ru.savin.personservice.core.repository.ContactRepository;
import ru.savin.personservice.dto.ContactDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    private ContactMapper contactMapper;

    @Override
    public ResponseEntity save(ContactDTO contactDTO) {
        return Optional.of(contactDTO)
                .map(contactMapper::getFromDTO)
                .map(x -> {
                    if (contactDTO.getEmail().isEmpty()) {
                        log.error("Данные о email пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    contactRepository.save(x);
                    return new ResponseEntity("Данные об адресе внесены", HttpStatus.OK);})
                .orElseThrow(() -> new EntityNotFoundException("Нельзя создать данные об адресе"));
    }

    @Override
    public ResponseEntity update(ContactDTO contactDTO) {
        return contactRepository.getContactByEmailAndPhoneNumber(contactDTO.getEmail(), contactDTO.getPhoneNumber())
                .map(update -> {
                    if (contactDTO.getEmail().isEmpty() || contactDTO.getPhoneNumber().isEmpty()) {
                        log.error("Данные пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    Contact contact = contactMapper.getFromDTO(contactDTO);
                    contactRepository.save(contact);
                    return ResponseEntity.ok(contactMapper.getFromModel(contact));})
                .orElseThrow(() -> new EntityNotFoundException("Невозможно обновить данные адреса"));
    }

    @Override
    public ResponseEntity<List<Contact>> getAll(String email) {
        List<Contact> contacts = contactRepository.getContactByEmail(email);
        return ResponseEntity.ok(contacts);
    }
}
