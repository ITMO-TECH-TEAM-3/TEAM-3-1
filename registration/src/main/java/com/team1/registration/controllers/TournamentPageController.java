package com.team1.registration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TournamentPageController {
    @GetMapping("tournament")
    public String tournament(){ // todo: fix name
        return "";
    }
}
