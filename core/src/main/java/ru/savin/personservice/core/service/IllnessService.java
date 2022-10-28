package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.IllnessMapper;
import ru.savin.personservice.core.model.Illness;

import java.util.List;

@Service
@AllArgsConstructor
public class IllnessService {
    private IllnessMapper illnessMapper;

    public List<Illness> getAll() {
        return illnessMapper.getAll();
    }
}
