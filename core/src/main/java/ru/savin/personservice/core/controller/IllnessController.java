package ru.savin.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.savin.personservice.core.mapper.IllnessMapper;
import ru.savin.personservice.core.model.Illness;

import java.util.List;

@RestController
@RequestMapping("/illness")
@Api(value = "Контроллер для работы с диагнозами")
public class IllnessController {
    private IllnessMapper illnessMapper;

    @GetMapping("/getAll")
    @ApiOperation(value = "Получение всех диагнозов клиентов")
    public List<Illness> getAll() {
        return illnessMapper.getAll();
    }
}
