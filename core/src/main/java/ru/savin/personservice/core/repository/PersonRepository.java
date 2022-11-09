package ru.savin.personservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savin.personservice.core.model.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> getPersonById(long id);
    Optional<Person> getPersonByLastName(String lastName);
    Optional<Person> getPersonByLastNameAndFirstName(String lastName, String firstName);
}
