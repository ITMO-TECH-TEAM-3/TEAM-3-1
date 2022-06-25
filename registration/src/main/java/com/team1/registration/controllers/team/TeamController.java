package com.team1.registration.controllers.team;

import com.team1.registration.services.PlayerService;
import com.team1.registration.services.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/teams")
public class TeamController {
    private TeamService teamService;
    private PlayerService playerService;

    @GetMapping
    public String options() {
        return "teams/options";
    }

    @GetMapping("/all")
    public String getAllTeams(Model model) {
        var teams = teamService.getAllTeams();
        var creators = teams.stream().map(team -> {
            var creatorId = team.getCreatorId();
            return playerService.getPlayerById(creatorId);
        }).collect(Collectors.toList());
        model.addAttribute("teams", teams);
        model.addAttribute("creators", creators);
        return "/teams/all-teams";
    }
}
