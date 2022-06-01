package com.team1.registration.controllers.player;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.services.PlayerService;
import com.team1.registration.services.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
@Slf4j
public class PlayerController {
    private PlayerService playerService;
    private TeamService teamService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK, reason = "player created")
    public void registerPlayer(@RequestBody Player player) {
        playerService.registerPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable Integer playerId) {
        return playerService.getPlayerById(playerId);
    }

    // todo: change endpoint
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "player added to new team")
    @PostMapping("/{playerId}/team/{teamId}")
    public void addTeam(@PathVariable Integer playerId, @PathVariable Integer teamId) {
        var player = playerService.getPlayerById(playerId);
        var team = teamService.getTeamById(teamId);
        if (team.getCreatorId() == null) {
            team.setCreatorId(playerId);
        }
        team.addPlayer(player);
        teamService.updateTeam(team);
        player.addTeam(team);
        playerService.updatePlayer(player);
    }
}
