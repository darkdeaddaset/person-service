package ru.savin.personservice.core.model.enums;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;

    @Override
    public String getAuthority() {
        return null;
    }

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
