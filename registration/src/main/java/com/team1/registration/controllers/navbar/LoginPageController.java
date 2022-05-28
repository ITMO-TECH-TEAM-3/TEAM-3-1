package com.team1.registration.controllers.navbar;

import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {
    @GetMapping("/login")
    public String login(){
        return "navbar/login";
    }
}