package com.team1.registration.controllers.rest;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.services.PlayerService;
import com.team1.registration.services.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/players-rest")
@Slf4j
public class PlayerRestController {
    private PlayerService playerService;
    private TeamService teamService;

    @PostMapping("/new")
    @ResponseStatus(value = HttpStatus.OK, reason = "player created")
    public void registerPlayer(@RequestBody Player player) {
        playerService.registerPlayer(player);
    }

    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "player joined to team")
    @PostMapping("/{playerId}/join-team/{teamId}")
    public void joinTeam(@PathVariable UUID playerId, @PathVariable UUID teamId) {
        var player = playerService.getPlayerById(playerId);
        var team = teamService.getTeamById(teamId);
        playerService.joinTeam(player, team);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "team created")
    @PostMapping("/{playerId}/new-team")
    public void createTeam(@PathVariable UUID playerId, @RequestBody Team team) {
        if (!playerService.containsPlayer(playerId)) {
            throw new NoSuchElementException(String.format("Player with '%s' doesn't exist!", playerId));
        }
        team.setCreatorId(playerId);
        teamService.registerTeam(team);
        playerService.joinTeam(playerService.getPlayerById(playerId), team);
    }

    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable UUID playerId) {
        playerService.deletePlayer(playerId);
    }
}
