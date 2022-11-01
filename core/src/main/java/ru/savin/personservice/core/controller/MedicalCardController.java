package ru.savin.personservice.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.mapper.MedicalCardMapper;
import ru.savin.personservice.core.model.MedicalCard;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medical")
public class MedicalCardController {
    private MedicalCardMapper mapper;

    @GetMapping("/all")
    public List<MedicalCard> getAllMedicalCard() {
        return mapper.getAllMedicalCard();
    }
}
