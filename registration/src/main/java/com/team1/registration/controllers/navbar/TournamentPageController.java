package com.team1.registration.controllers.navbar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TournamentPageController {
    @GetMapping("tournaments")
    public String tournaments(){ // todo: fix name
        return "tournaments";
    }
}
