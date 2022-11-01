package ru.savin.personservice.core.mapper.mapstrcut;

import org.mapstruct.Mapper;
import ru.savin.personservice.core.model.User;
import ru.savin.personservice.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapstruct {
    User getFromSingUp(UserDTO userDTO);
    UserDTO getFromUser(User user);
}
