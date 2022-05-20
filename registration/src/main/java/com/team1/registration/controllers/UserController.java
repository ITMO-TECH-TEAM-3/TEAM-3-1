package com.team1.registration.controllers;

import com.team1.registration.models.User;
import com.team1.registration.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("users")
public record UserController(UserService userService) {

    //todo: match endpoints
    @PostMapping
    public void registerUser(@RequestBody User user) {
        log.info("New user registration");
        userService.registerUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
