package ru.savin.personservice.core.service.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.savin.personservice.core.mapper.RolesMapper;
import ru.savin.personservice.core.mapper.UserMapper;
import ru.savin.personservice.core.model.User;
import ru.savin.personservice.core.model.enums.Role;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private UserMapper userMapper;
    private RolesMapper rolesMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userMapper.getUser(login)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
        return build(user);
    }

    public static User build(User user) {
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .collect(Collectors.toList());
        return new User(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                authorities);
    }
}
