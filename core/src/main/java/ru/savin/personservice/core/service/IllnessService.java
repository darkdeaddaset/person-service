package ru.savin.personservice.core.service;

import org.springframework.http.ResponseEntity;
import ru.savin.personservice.core.model.Illness;
import ru.savin.personservice.dto.IllnessDTO;

public interface IllnessService {
    ResponseEntity<String> save(IllnessDTO illnessDTO);
    ResponseEntity update(IllnessDTO illnessDTO);
    Illness getAll(String heaviness, long typeId);
}
