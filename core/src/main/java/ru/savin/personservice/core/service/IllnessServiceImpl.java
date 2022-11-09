package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.IllnessMapper;
import ru.savin.personservice.core.model.Illness;
import ru.savin.personservice.core.repository.IllnessRepository;
import ru.savin.personservice.dto.IllnessDTO;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class IllnessServiceImpl implements IllnessService{
    private IllnessRepository illnessRepository;
    private IllnessMapper illnessMapper;

    @Override
    public ResponseEntity save(IllnessDTO illnessDTO) {
        return Optional.of(illnessDTO)
                .map(illnessMapper::getFromDTO)
                .map(x -> {
                    if (illnessDTO.getAppearanceDttm() == null) {
                        log.error("Данные пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    illnessRepository.save(x);
                    return new ResponseEntity("Данные об адресе внесены", HttpStatus.OK);})
                .orElseThrow(() -> new EntityNotFoundException("Нельзя создать данные об адресе"));
    }

    @Override
    public ResponseEntity update(IllnessDTO illnessDTO) {
        return illnessRepository.getIllnessesByHeaviness(String.valueOf(illnessDTO.getHeaviness()))
                .map(update -> {
                    if (illnessDTO.getAppearanceDttm() == null) {
                        log.error("Данные пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    Illness illness = illnessMapper.getFromDTO(illnessDTO);
                    illnessRepository.save(illness);
                    return ResponseEntity.ok(illnessMapper.getFromModel(illness));})
                .orElseThrow(() -> new EntityNotFoundException("Невозможно обновить данные адреса"));
    }

    @Override
    public Illness getAll(String heaviness, long typeId) {
        return illnessRepository.getIllnessesByHeaviness(heaviness)
                .orElseThrow();
    }
}
