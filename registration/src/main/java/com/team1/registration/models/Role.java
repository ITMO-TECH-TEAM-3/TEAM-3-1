package com.team1.registration.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    UNAUTHORIZED_USER,
    AUTHORIZED_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
