package com.team1.registration.controllers.team;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {
    private TeamService teamService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK, reason = "created team")
    public void registerTeam(@RequestBody Team team) {
        teamService.registerTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{teamId}")
    public Team getTeam(@PathVariable Integer teamId) {
        return teamService.getTeamById(teamId);
    }
}
