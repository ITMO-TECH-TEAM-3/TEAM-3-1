package com.team1.registration.controllers.player;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping
    public String options() {
        return "profile/options";
    }
}
