package ru.savin.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.savin.personservice.core.model.Address;
import ru.savin.personservice.core.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
@Api(value = "API для работы с адресами")
public class AddressController {
    private AddressService addressService;

    @GetMapping("/all")
    @ApiOperation(value = "Получение всех адресов")
    public List<Address> getAll() {
        return addressService.getAll();
    }
}
