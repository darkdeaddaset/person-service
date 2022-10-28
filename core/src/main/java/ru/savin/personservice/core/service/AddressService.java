package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.AddressMapper;
import ru.savin.personservice.core.model.Address;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressMapper addressMapper;

    public List<Address> getAll() {
        return addressMapper.getAllAddress();
    }
}
