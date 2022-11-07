package ru.savin.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.mapper.ContactMapper;
import ru.savin.personservice.core.model.Contact;

import java.util.List;

@RestController
@RequestMapping("/contact")
@Api(value = "Контроллер для работы с контактами клиентов")
@AllArgsConstructor
public class ContactController {
    private ContactMapper contactMapper;

    @GetMapping("/all")
    @ApiOperation(value = "Получение всех контактов клиентов")
    public List<Contact> getAll() {
        return contactMapper.getAll();
    }
}
