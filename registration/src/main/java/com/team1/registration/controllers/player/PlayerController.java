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
        log.info("Clicked to create player form");
        return "players/new-player";
    }

    @PostMapping("/new-player")
    public String createPlayer(Player player) {
        playerService.registerPlayer(player);
        log.info("Player created '{}'", player.getName());
        return "redirect:/";
    }

    @GetMapping("all")
    public String getAllUserPlayers( Integer userId, Model model) {
        var players = playerService.getPlayersByUserId(userId);
        model.addAttribute("players", players);
        return "players/all-players";
    }

    @GetMapping("new-team")
    public String createTeamForm() {
        return "players/new-team";
    }

    //todo: how to pass selected player?
    @PostMapping("new-team")
    public String createTeam(Player player, Team team) {
        log.info("Player '{}' created team '{}'", player, team);
        teamService.registerTeam(team);
        playerService.joinTeam(player, team);
        return "redirect:/";
    }

    //todo: how to pass selected player?
    @GetMapping("join-team")
    public void joinTeam(Player player, Team team) {
        log.info("Player '{}' joined team '{}'", player, team);
        playerService.joinTeam(player, team);
    }
}
