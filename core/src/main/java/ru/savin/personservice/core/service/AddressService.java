package ru.savin.personservice.core.service;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import ru.savin.personservice.core.model.Address;
import ru.savin.personservice.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    ResponseEntity<String> saveNewAddress(AddressDTO addressDTO);
    ResponseEntity<AddressDTO> updateAddress(AddressDTO addressDTO);
    ResponseEntity<List<Address>> getAddress(String city);
}
