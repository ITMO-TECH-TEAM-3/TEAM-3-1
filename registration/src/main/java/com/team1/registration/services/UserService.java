package com.team1.registration.services;

import com.team1.registration.models.User;
import com.team1.registration.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserService(UserRepository userRepository) {
    public void registerUser(User user) {
        //todo: check data for correctness
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
