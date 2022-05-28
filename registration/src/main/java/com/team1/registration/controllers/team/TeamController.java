package com.team1.registration.controllers.team;

import com.team1.registration.models.Team;
import com.team1.registration.services.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping("teams")
@AllArgsConstructor
@Slf4j
public class TeamController {
    private TeamService teamService;

    @PostMapping
    public void registerTeam(@RequestBody Team team) {
        log.info("New team registration");
        teamService.registerTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }
}
