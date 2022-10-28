package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.MedicalCardMapper;
import ru.savin.personservice.core.model.MedicalCard;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicalCardService {
    private MedicalCardMapper medicalCardMapper;

    public List<MedicalCard> getAll() {
        return medicalCardMapper.getAllMedicalCard();
    }
}
