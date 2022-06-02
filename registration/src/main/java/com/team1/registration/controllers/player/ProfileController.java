package com.team1.registration.controllers.player;

import com.team1.registration.models.Player;
import com.team1.registration.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
@Slf4j
@AllArgsConstructor
public class ProfileController {
    private PlayerService playerService;

    @GetMapping
    public String options() {
        log.info("Clicked to profile options");
        return "profile/options";
    }

    @GetMapping("/create-player")
    public String playerForm() {
        log.info("Clicked to create player form");
        return "profile/create-player";
    }

    @GetMapping("/make-bet")
    public String betForm() {
        return "profile/make-bet";
    }

    @PostMapping("/create-player")
    public String createPlayer(Player player) {
        playerService.registerPlayer(player);
        log.info(String.format("Player created '%s'", player));
        return "redirect:/";
    }
}
