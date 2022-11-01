package ru.savin.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import ru.savin.personservice.core.model.enums.Role;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private long id;
    private String login;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private Collection<? extends GrantedAuthority> authorities;

    public User(long id,
                String login,
                String password,
                Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public User(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
