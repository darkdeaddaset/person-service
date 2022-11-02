package ru.savin.personservice.core.service;

import org.springframework.http.ResponseEntity;
import ru.savin.personservice.dto.JwtResponse;
import ru.savin.personservice.dto.UserDTO;

public interface UserService {
    ResponseEntity registry(UserDTO userDTO);
    JwtResponse login(UserDTO userDTO);
}
