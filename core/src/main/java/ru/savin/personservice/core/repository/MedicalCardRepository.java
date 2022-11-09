package ru.savin.personservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savin.personservice.core.model.MedicalCard;
import ru.savin.personservice.core.model.Person;

import java.util.Optional;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {
    Optional<MedicalCard> getMedicalCardByPerson(long person);
}
