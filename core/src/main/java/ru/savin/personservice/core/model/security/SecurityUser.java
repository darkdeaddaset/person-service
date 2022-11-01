package ru.savin.personservice.core.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.savin.personservice.core.model.User;

import java.util.Collection;
/*
Сделан данный класс для удобочитаемости
*/

public class SecurityUser extends User implements UserDetails {
    private User user;

    public SecurityUser(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
//        this.user.setId(id);
//        this.user.setLogin(login);
//        this.user.setPassword(password);
//        this.user.setAuthorities(authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities() ;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
