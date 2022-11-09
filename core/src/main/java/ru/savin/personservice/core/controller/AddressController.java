package ru.savin.personservice.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.model.Address;
import ru.savin.personservice.core.service.AddressService;
import ru.savin.personservice.dto.AddressDTO;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;

    @GetMapping("/{city}")
    ResponseEntity<List<Address>> getAll(@PathVariable("city") String city) {
        return addressService.getAddress(city);
    }

    @PostMapping("/save")
    ResponseEntity createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.saveNewAddress(addressDTO);
    }

    @PutMapping("/update")
    ResponseEntity updateAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.updateAddress(addressDTO);
    }
}
