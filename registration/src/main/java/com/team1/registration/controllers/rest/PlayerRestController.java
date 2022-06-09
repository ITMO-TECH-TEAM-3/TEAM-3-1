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

    // todo: change endpoint
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "player joined to team")
    @PostMapping("/{playerId}/join-team/{teamId}")
    public void joinTeam(@PathVariable UUID playerId, @PathVariable UUID teamId) {
        var player = playerService.getPlayerById(playerId);
        var team = teamService.getTeamById(teamId);
        playerService.joinTeam(player, team);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "new team created")
    @PostMapping("/{playerId}/new-team")
    public void createTeam(@PathVariable UUID playerId, @RequestBody Team team) {
        // maybe: take out method logic to service?
        if (!playerService.containsPlayer(playerId)) {
            return;
        }
        //todo: add response status for the case of not finding the player
        team.setCreatorId(playerId);
        teamService.registerTeam(team);
        this.joinTeam(playerId, team.getId());
    }
}
