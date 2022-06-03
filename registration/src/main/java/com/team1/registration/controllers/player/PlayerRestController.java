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
@RequestMapping("/players-rest")
@Slf4j
public class PlayerRestController {
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
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "player joined to team")
    @PostMapping("/{playerId}/join-team/{teamId}")
    public void joinTeam(@PathVariable Integer playerId, @PathVariable Integer teamId) {
        var player = playerService.getPlayerById(playerId);
        var team = teamService.getTeamById(teamId);
        teamService.addPlayerToTeam(team, player);
        teamService.updateTeam(team);
        playerService.addTeamToPlayer(player, team);
        playerService.updatePlayer(player);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "new team created")
    @PostMapping("{playerId}/new-team")
    public void createTeam(@PathVariable Integer playerId, @RequestBody Team team) {
        if (!playerService.containsPlayer(playerId)) {
            return;
        }
        //todo: add response status for the case of not finding the player
        team.setCreatorId(playerId);
        teamService.registerTeam(team);
        this.joinTeam(playerId, team.getId());
    }
}
