package ru.savin.personservice.core.mapper;

import org.mapstruct.Mapper;
import ru.savin.personservice.core.model.Contact;
import ru.savin.personservice.dto.ContactDTO;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact getFromDTO(ContactDTO contactDTO);
    ContactDTO getFromModel(Contact contact);
}
