package ru.savin.personservice.core.utils;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import ru.savin.personservice.core.model.enums.Role;
import ru.savin.personservice.core.model.jwt.JwtAuthentication;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    public static JwtAuthentication generate(Claims claims){
        JwtAuthentication jwtAuthentication = new JwtAuthentication();
        jwtAuthentication.setLogin(claims.getSubject());
        jwtAuthentication.setRoles(getRole(claims));
        return jwtAuthentication;
    }

    private static Set<Role> getRole(Claims claims){
        List<String> role = claims.get("role", List.class);
        return role.stream()
                .map(Role::valueOf)
                .collect(Collectors.toSet());
    }
}
