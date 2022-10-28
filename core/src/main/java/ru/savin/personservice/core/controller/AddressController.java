package ru.savin.personservice.core.controller;

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
public class AddressController {
    private AddressService addressService;

    @GetMapping("/all")
    public List<Address> getAll() {
        return addressService.getAll();
    }
}
