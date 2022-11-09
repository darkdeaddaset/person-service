package ru.savin.personservice.core.service;

import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import ru.savin.personservice.dto.JwtResponse;
import ru.savin.personservice.dto.UserDTO;

import javax.security.auth.message.AuthException;

public interface UserService {
    ResponseEntity registry(UserDTO userDTO);
    JwtResponse login(UserDTO userDTO);
    //JwtResponse refresh(@NonNull String refreshToken) throws AuthException;
}
