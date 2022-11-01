package ru.savin.personservice.core.controller;

import liga.medical.dto.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.savin.personservice.core.service.UserService;
import ru.savin.personservice.dto.UserDTO;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<JwtResponse> singIn(@RequestBody UserDTO userDTO) {
        return userService.registry(userDTO);
    }

    @PostMapping("/sign-in")
    public ResponseEntity signUp(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }
}
