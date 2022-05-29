package com.team1.registration.controllers.player;

import com.team1.registration.models.Player;
import com.team1.registration.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    @PostMapping
    public void registerPlayer(@RequestBody Player player) {
        playerService.registerPlayer(player);
    }

    @GetMapping
    public List<Player> getAllUsers() {
        return playerService.getAllPlayers();
    }


    /*
        todo: create new team for player
        this method can be in other controller?
     */
}
