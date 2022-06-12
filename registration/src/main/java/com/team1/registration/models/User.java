package com.team1.registration.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    private UUID id = UUID.randomUUID();

    @NotBlank(message = "Enter your name")
    @Length(max = 256, message = "Name is too long")
    @NotNull
    private String username;


    @NotBlank(message = "Enter password")
    @Length(max = 256, message = "Password is too long")
    @NotNull
    private String password;

    @DecimalMin(value = "0.0")
    private BigDecimal balance = new BigDecimal(new BigInteger("0"), 2);

    private Boolean active = false;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @EqualsAndHashCode.Exclude
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAuthorized() {
        return roles.contains(Role.AUTHORIZED_USER);
    }
}
