package com.team1.registration.controllers.rest;

import com.team1.registration.models.Player;
import com.team1.registration.models.dto.PlayerDto;
import com.team1.registration.models.dto.TeamDto;
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
    public void registerPlayer(@RequestBody PlayerDto playerDto) {
        playerService.registerPlayer(playerDto);
    }

    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "player joined to team")
    @PostMapping("/{playerId}/join-team/{teamId}")
    public void joinTeam(@PathVariable UUID playerId, @PathVariable UUID teamId) {
        playerService.joinTeam(
                playerService.getPlayerById(playerId),
                teamService.getTeamById(teamId)
        );
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "team created")
    @PostMapping("/new-team")
    public void createTeam(@RequestBody TeamDto teamDto) {
        teamService.registerTeam(teamDto);
    }

    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable UUID playerId) {
        playerService.deletePlayer(playerId);
    }
}
