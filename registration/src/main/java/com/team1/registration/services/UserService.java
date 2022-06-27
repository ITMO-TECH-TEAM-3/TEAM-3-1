package com.team1.registration.services;

import com.team1.registration.models.Role;
import com.team1.registration.models.User;
import com.team1.registration.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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

    public boolean registerUser(User user, HttpServletRequest httpServletRequest) {
        log.info("New user registration '{}'", user.getUsername());
        User userFromDb = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (userFromDb != null) {
            return false;
        }
        String decodePassword = user.getPassword();
        user.setRoles(Collections.singleton(Role.AUTHORIZED_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        try{
            httpServletRequest.login(user.getUsername(), decodePassword);
        }
        catch (ServletException e){
            log.debug("auto login failed");
        }
        return true;
    }

    public User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException(userId.toString()));
    }

    public void updateBalance(User user, BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("0.0")) <= 0) {
            throw new IllegalArgumentException("Replenishment amount should be positive!");
        }
        log.info("'{}' balance '{}' before replenishment", user.getUsername(), user.getBalance());
        user.setBalance(user.getBalance().add(amount));
        log.info("'{}' balance '{}' after replenishment", user.getUsername(), user.getBalance());
        userRepository.save(user);
    }

    public void login(User user) {
        log.debug("Login by user '{}'", user.getUsername());
        var userFromDb = this.loadUserByUsername(user.getUsername());
        if (!passwordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }
        userFromDb.getRoles().add(Role.AUTHORIZED_USER);
        userFromDb.setActive(true);
        userRepository.save(userFromDb);

    }

    public void logout(UUID userId) {
        log.debug("Logout by user '{}'", userId);
        var userFromDb = this.getUserById(userId);
        userRepository.save(userFromDb);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(UUID userId) {
        log.info("Deleting user '{}'", userId);
        userRepository.delete(this.getUserById(userId));
    }

    public User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException(username));
    }
}
