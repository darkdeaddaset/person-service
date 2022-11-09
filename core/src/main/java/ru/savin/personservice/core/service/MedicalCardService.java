package ru.savin.personservice.core.service;

import org.springframework.http.ResponseEntity;
import ru.savin.personservice.core.model.MedicalCard;
import ru.savin.personservice.dto.IllnessDTO;
import ru.savin.personservice.dto.MedicalCardDTO;

public interface MedicalCardService {
    ResponseEntity save(MedicalCardDTO medicalCardDTO);
    ResponseEntity update(MedicalCardDTO medicalCardDTO);
    MedicalCard getAll(long person);
}
