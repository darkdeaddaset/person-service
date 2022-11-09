package ru.savin.personservice.core.mapper;

import org.mapstruct.Mapper;
import ru.savin.personservice.core.model.Illness;
import ru.savin.personservice.dto.IllnessDTO;

@Mapper(componentModel = "spring")
public interface IllnessMapper {
    Illness getFromDTO(IllnessDTO illnessDTO);
    IllnessDTO getFromModel(Illness illness);
}
