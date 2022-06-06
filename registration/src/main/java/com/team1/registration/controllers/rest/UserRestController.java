package com.team1.registration.controllers.rest;

import com.team1.registration.models.User;
import com.team1.registration.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/users-rest")
@AllArgsConstructor
public class UserRestController {
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        log.info("{} user", user);
        userService.registerUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/login")
    @ResponseStatus(value = HttpStatus.OK, reason = "login")
    public void login(@RequestBody User user) {
        userService.login(user);
    }

    @GetMapping("/logout")
    @ResponseStatus(value = HttpStatus.OK, reason = "logout")
    public void logout(@RequestBody UUID userId) {
        var user = userService.getUserById(userId);
        userService.logout(user);
    }
}
