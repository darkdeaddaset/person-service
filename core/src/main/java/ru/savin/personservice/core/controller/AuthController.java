package ru.savin.personservice.core.controller;

import liga.medical.dto.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.savin.personservice.core.mapper.RolesMapper;
import ru.savin.personservice.core.mapper.UserMapper;
import ru.savin.personservice.core.service.UserService;
import ru.savin.personservice.dto.UserDTO;

import javax.security.auth.message.AuthException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private UserService userService;
    private UserMapper userMapper;
    private RolesMapper rolesMapper;

    @GetMapping("/test")
    public void getIdRole() {
        System.out.println(rolesMapper.getByRoleId(1));
        System.out.println(rolesMapper.getNameRole(rolesMapper.getByRoleId(1)));
    }
    @PostMapping("/sign-up")
    public ResponseEntity<JwtResponse> singIn(@RequestBody UserDTO userDTO) {
        return userService.registry(userDTO);
    }

    @PostMapping("/sign-in")
    public ResponseEntity signUp(@RequestBody UserDTO userDTO) {
        ru.savin.personservice.dto.JwtResponse token;

        try {
            token = userService.login(userDTO);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(token);
    }
}
