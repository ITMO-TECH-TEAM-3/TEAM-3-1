package com.team1.registration.services;

import com.team1.registration.models.Role;
import com.team1.registration.models.User;
import com.team1.registration.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Not found user by %s", username)));
    }

    public boolean registerUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.AUTHORIZED_USER));
//        user.setActive(false);
//        user.setRoles(Collections.singleton(Role.UNAUTHORIZED_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("registration of new user {}", user);
        return true;
    }

    public User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException(userId.toString()));
    }

    public void updateBalance(User user, Double amount) {
        // todo: checks
        user.setBalance(user.getBalance() + amount);
        userRepository.save(user);
    }

    // For RestControllers
    public void login(User user) {
        var userFromDb = this.loadUserByUsername(user.getUsername());
        if (!passwordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            throw new InputMismatchException("Incorrect password");
        }
//        userFromDb.setRoles(Collections.singleton(Role.AUTHORIZED_USER));
        userFromDb.getRoles().add(Role.AUTHORIZED_USER);
        userFromDb.setActive(true);
        userRepository.save(userFromDb);
        log.info("login by user {}", userFromDb.getUsername());
    }

    public void logout(UUID userId) {
        var userFromDb = this.getUserById(userId);
        userFromDb.setActive(false);
//        userFromDb.setRoles(Collections.singleton(Role.UNAUTHORIZED_USER));
        userFromDb.getRoles().add(Role.UNAUTHORIZED_USER);
        userRepository.save(userFromDb);
        log.info("logout by user {}", userFromDb.getUsername());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
