package com.team1.registration.controllers.player;

import com.team1.registration.models.Player;
import com.team1.registration.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK, reason = "player created")
    public void registerPlayer(@RequestBody Player player) {
        playerService.registerPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{playerId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "player updated")
    public void updatePlayer(@PathVariable Integer playerId, @RequestBody Player player) {
        playerService.updatePlayer(playerId, player);
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable Integer playerId) {
        return playerService.getPlayerById(playerId);
    }

    /*
        todo: create new team for player
        this method can be in other controller?
     */
}
