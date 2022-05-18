package com.team1.registration.controllers;

import com.team1.registration.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//todo: match endpoints
public record UserController(UserService userService) {

    @PostMapping
    public void registerUser() {
        log.info("new user registration");
        userService.registerUser();
    }
}
