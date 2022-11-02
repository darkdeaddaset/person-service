package ru.savin.personservice.core.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.RolesMapper;
import ru.savin.personservice.core.mapper.UserMapper;
import ru.savin.personservice.core.mapper.mapstrcut.UserMapstruct;
import ru.savin.personservice.core.model.User;
import ru.savin.personservice.core.model.enums.Role;
import ru.savin.personservice.core.utils.JwtProvider;
import ru.savin.personservice.dto.JwtResponse;
import ru.savin.personservice.dto.UserDTO;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private JwtProvider jwtProvider;
    private RolesMapper rolesMapper;
    private UserMapper userMapper;
    private UserMapstruct userMapstruct;
    private Map<String, String> refreshStorage = new HashMap<>();

    @Override
    public ResponseEntity registry(UserDTO userDTO) {
        return Optional.of(userDTO)
                .map(userMapstruct::getFromSingUp)
                .map(save -> {
                    if (userDTO.getLogin() == null || userDTO.getLogin().length() < 8
                    || userDTO.getPassword() == null || userDTO.getPassword().length() < 8) {
                        throw new RuntimeException("Имя пользователя или пароль не соответствует критериям валидации");
                    }
                    userMapper.save(save);
                    long role_id = rolesMapper.getRole(Role.USER.toString());
                    long user_id = userMapper.getIdOfUser(userDTO.getLogin());
                    rolesMapper.save(role_id, user_id);
                return ResponseEntity.ok("Пользователь создан");})
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не может быть создан"));
    }

    @Override
    public JwtResponse login(UserDTO userDTO) {
        User user = userMapper.getUserByLoginAndPassword(userDTO.getLogin(), userDTO.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));

        if (user.getPassword().equals(user.getPassword())){
            String accessToken = jwtProvider.generateAccessToken(user);
            String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getLogin(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new RuntimeException("Пароль неверный");
        }
        /*return userMapper.getUserByLoginAndPassword(userDTO.getLogin(), userDTO.getPassword())
                .map(login -> {
                    UserDTO userDTO1 = userMapstruct.getFromUser(login);
                    return ResponseEntity.ok(userDTO1);
                }).orElseThrow(() -> new RuntimeException("Пользователь с такими данными не найден"));*/
    }
}
