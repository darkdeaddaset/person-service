package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.UserMapper;
import ru.savin.personservice.core.model.User;
import ru.savin.personservice.core.model.enums.Role;
import ru.savin.personservice.core.repository.UserRepository;
import ru.savin.personservice.core.utils.JwtProvider;
import ru.savin.personservice.dto.JwtResponse;
import ru.savin.personservice.dto.UserDTO;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private JwtProvider jwtProvider;
    private UserRepository userRepository;
    private UserMapper userMapper;
    private Map<String, String> refreshStorage = new HashMap<>();

    private Set<Role> roleAdmin(){
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.add(Role.ADMIN);

        return rolesSet;
    }

    private Set<Role> roleUser(){
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.add(Role.USER);

        return rolesSet;
    }

    @Override
    public ResponseEntity registry(UserDTO userDTO) {
        return Optional.of(userDTO)
                .map(userMapper::getFromSingUp)
                .map(save -> {
                    if (userDTO.getLogin() == null || userDTO.getLogin().length() < 8
                    || userDTO.getPassword() == null || userDTO.getPassword().length() < 8) {
                        throw new RuntimeException("Имя пользователя или пароль не соответствует критериям валидации");
                    }
                    save.setRole(roleAdmin());
                    userRepository.save(save);
                return ResponseEntity.ok("Пользователь создан");})
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не может быть создан"));
    }

    @Override
    public JwtResponse login(UserDTO userDTO) {
        User user = userRepository.getUserByLoginAndPassword(userDTO.getLogin(), userDTO.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
        if (userDTO.getPassword().equals(user.getPassword())) {
            String accessToken = jwtProvider.generateAccessToken(user);
            String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getLogin(), refreshToken);
            return new JwtResponse(accessToken);
        } else {
            throw new RuntimeException("Пароль неверный");
        }
    }

   /* @Override
    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefresh(refreshToken)){
            Claims claims = jwtProvider.getRefreshToken(refreshToken);
            String name = claims.getSubject();
            String saveRefreshToken = refreshStorage.get(name);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)){
                User user = userMapper.getUser(name)
                        .orElseThrow(()-> new AuthException("Пользователь не найден"));
                String accessToken = jwtProvider.generateAccessToken(user);
                String refreshNewToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getLogin(), refreshNewToken);
                return new JwtResponse(accessToken, refreshToken);
            }
        }
        throw new AuthException("Невалидный токен");
    }*/
}
