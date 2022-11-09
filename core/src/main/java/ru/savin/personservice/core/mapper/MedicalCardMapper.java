package ru.savin.personservice.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.savin.personservice.core.model.MedicalCard;
import ru.savin.personservice.dto.MedicalCardDTO;

@Mapper(componentModel = "spring")
public interface MedicalCardMapper {
    @Mapping(target = "person.id", source = "person")
    MedicalCard getFromDTO(MedicalCardDTO medicalCardDTO);
    @Mapping(target = "person", source = "person.id")
    MedicalCardDTO getFromModel(MedicalCard medicalCard);
}
