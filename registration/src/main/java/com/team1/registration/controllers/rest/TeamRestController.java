package com.team1.registration.controllers.rest;

import com.team1.registration.models.Team;
import com.team1.registration.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teams-rest")
@AllArgsConstructor
public class TeamRestController {
    private TeamService teamService;

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{teamId}")
    public Team getTeam(@PathVariable UUID teamId) {
        return teamService.getTeamById(teamId);
    }
}
