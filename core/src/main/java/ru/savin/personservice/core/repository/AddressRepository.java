package ru.savin.personservice.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savin.personservice.core.model.Address;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> getAddressesByCityAndStreet(String city, String street);
    List<Address> getAddressesByCity(String city);
}
