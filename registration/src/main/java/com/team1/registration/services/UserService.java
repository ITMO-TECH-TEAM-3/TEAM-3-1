package com.team1.registration.services;

import com.team1.registration.models.Role;
import com.team1.registration.models.User;
import com.team1.registration.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean registerUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.AUTHORIZED_USER));
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
        // todo: return correct responses
        var prevUser = this.getUserById(user.getId());
        if (!prevUser.getUsername().equals(user.getUsername()) || !prevUser.getPassword().equals(user.getPassword())) {
            throw new InputMismatchException(String.format("%s login data is incorrect", user));
        }
        user.setRoles(Collections.singleton(Role.AUTHORIZED_USER));
        user.setActive(true);
        userRepository.save(user);
        log.info("login by user {}", user);
    }

    public void logout(User user) {
        user.setActive(false);
        user.setRoles(Collections.singleton(Role.UNAUTHORIZED_USER));
        userRepository.save(user);
        log.info("logout by user {}", user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
