package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.AddressMapper;
import ru.savin.personservice.core.model.Address;
import ru.savin.personservice.core.repository.AddressRepository;
import ru.savin.personservice.dto.AddressDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;


    @Override
    public ResponseEntity saveNewAddress(AddressDTO addressDTO) {
        return Optional.of(addressDTO)
                .map(addressMapper::getFromDTO)
                .map(x -> {
                    if (addressDTO.getCity().isEmpty()) {
                        log.error("Данные о городе пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    addressRepository.save(x);
                return new ResponseEntity("Данные об адресе внесены", HttpStatus.OK);})
                .orElseThrow(() -> new EntityNotFoundException("Нельзя создать данные об адресе"));
    }

    @Override
    public ResponseEntity updateAddress(AddressDTO addressDTO) {
        return addressRepository.getAddressesByCityAndStreet(addressDTO.getCity(), addressDTO.getStreet())
                .map(update -> {
                    if (addressDTO.getCity().isEmpty() || addressDTO.getStreet().isEmpty()) {
                        log.error("Данные о городе пусты!");
                        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
                    }
                    Address address = addressMapper.getFromDTO(addressDTO);
                    addressRepository.save(address);
                    return ResponseEntity.ok(addressMapper.getFromModel(address));})
                .orElseThrow(() -> new EntityNotFoundException("Невозможно обновить данные адреса"));
    }

    public ResponseEntity<List<Address>> getAddress(String city) {
        List<Address> address =  addressRepository.getAddressesByCity(city);
        return ResponseEntity.ok(address);
    }
}
