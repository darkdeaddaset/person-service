package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.MedicalCardMapper;
import ru.savin.personservice.core.model.MedicalCard;
import ru.savin.personservice.core.repository.MedicalCardRepository;
import ru.savin.personservice.dto.MedicalCardDTO;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class MedicalCardServiceImpl implements MedicalCardService {
    private MedicalCardMapper medicalCardMapper;
    private MedicalCardRepository medicalCardRepository;

    @Override
    public ResponseEntity save(MedicalCardDTO medicalCardDTO) {
        return Optional.of(medicalCardDTO)
                .map(medicalCardMapper::getFromDTO)
                .map(x -> {
                    if (medicalCardDTO.getPerson() == 0) {
                        log.error("Данные о медицинской карте пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    medicalCardRepository.save(x);
                    return new ResponseEntity("Данные внесены", HttpStatus.OK);})
                .orElseThrow(() -> new EntityNotFoundException("Нельзя создать данные"));
    }

    @Override
    public ResponseEntity update(MedicalCardDTO medicalCardDTO) {
        return medicalCardRepository.getMedicalCardByPerson(medicalCardDTO.getPerson())
                .map(update -> {
                    MedicalCard medicalCard = medicalCardMapper.getFromDTO(medicalCardDTO);
                    medicalCardRepository.save(medicalCard);
                    return ResponseEntity.ok(medicalCardMapper.getFromModel(medicalCard));})
                .orElseThrow(() -> new EntityNotFoundException("Невозможно обновить данные"));
    }

    public MedicalCard getAll(long person) {
        return medicalCardRepository.getMedicalCardByPerson(person)
                .orElseThrow(() -> new EntityNotFoundException("Карта не найдена"));
    }
}
