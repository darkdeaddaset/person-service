package ru.savin.personservice.core.mapper;

import org.mapstruct.Mapper;
import ru.savin.personservice.core.model.Person;
import ru.savin.personservice.dto.PersonDTO;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person getFromDTO(PersonDTO personDTO);
    PersonDTO getFromModel(Person person);
}
