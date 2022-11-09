package ru.savin.personservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savin.personservice.core.model.Contact;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> getContactByEmailAndPhoneNumber(String email, String phoneNumber);
    List<Contact> getContactByEmail(String email);
}
