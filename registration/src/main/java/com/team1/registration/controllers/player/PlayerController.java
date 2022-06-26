package com.team1.registration.controllers.player;


import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.services.PlayerService;
import com.team1.registration.services.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;
    private TeamService teamService;

    @GetMapping
    public String options() {
        return "players/options";
    }

    @GetMapping("/new-player")
    public String createPlayerForm() {
        return "players/new-player";
    }

    @PostMapping("/new-player")
    public String createPlayer(Player player, RedirectAttributes attr) {
        playerService.registerPlayer(player);
        attr.addFlashAttribute("create_player_alert",
                String.format("Player %s successfully created!", player.getName()));
        return "redirect:/players";
    }

    @GetMapping("/all")
    public String getAllUserPlayers(@RequestParam UUID userId, Model model) {
        var players = playerService.getPlayersByUserId(userId);
        model.addAttribute("players", players);
        return "players/all-players";
    }

    @GetMapping("/new-team")
    public String createTeamForm(@RequestParam UUID userId, Model model) {
        var currentUserPlayers = playerService.getPlayersByUserId(userId);
        model.addAttribute("players", currentUserPlayers);
        return "players/new-team";
    }

    @PostMapping("/new-team")
    public String createTeam(Team team, RedirectAttributes attr) {
        var player = playerService.getPlayerById(team.getCreatorId());
        teamService.registerTeam(team);
        playerService.joinTeam(player, team);
        attr.addFlashAttribute("create_team_alert",
                String.format("Team %s successfully created by %s!", team.getName(), player.getName()));
        return "redirect:/players";

    }

    @GetMapping("/join-team")
    public String joinTeamForm(@RequestParam UUID userId, Model model) {
        var currentUserPlayers = playerService.getPlayersByUserId(userId);
        var teams = teamService.getAllTeams();
        model.addAttribute("players", currentUserPlayers);
        model.addAttribute("teams", teams);
        return "players/join-team";
    }

    @PostMapping("/join-team")
    public String joinTeam(@RequestParam UUID playerId, @RequestParam UUID teamId, RedirectAttributes attr) {
        var player = playerService.getPlayerById(playerId);
        var team = teamService.getTeamById(teamId);
        playerService.joinTeam(player, team);
        attr.addFlashAttribute("join_team_alert",
                String.format("Player %s successfully joined %s team!", player.getName(), team.getName()));
        return "redirect:/players";
    }
}
