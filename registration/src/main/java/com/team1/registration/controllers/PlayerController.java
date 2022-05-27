package com.team1.registration.controllers;

import com.team1.registration.models.Player;
import com.team1.registration.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    @PostMapping
    public void registerPlayer(@RequestBody Player player) {
        log.info("New player registration");
        playerService.registerPlayer(player);
    }

    @GetMapping
    public List<Player> getAllUsers() {
        return playerService.getAllPlayers();
    }
}
