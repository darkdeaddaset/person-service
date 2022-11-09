package ru.savin.personservice.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.savin.personservice.core.model.Address;
import ru.savin.personservice.dto.AddressDTO;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "contactId.id", source = "contactId")
    Address getFromDTO(AddressDTO addressDTO);

    @Mapping(target = "contactId", source = "contactId.id")
    AddressDTO getFromModel(Address address);
}
