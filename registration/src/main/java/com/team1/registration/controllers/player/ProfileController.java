package com.team1.registration.controllers.player;

import com.team1.registration.models.Player;
import com.team1.registration.services.PlayerService;
import com.team1.registration.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
@Slf4j
@AllArgsConstructor
public class ProfileController {
    private PlayerService playerService;
    private UserService userService;

    @GetMapping
    public String options() {
        log.info("Clicked to profile options");
        return "profile/options";
    }

    @GetMapping("/create-player")
    public String playerForm() {
        log.info("Clicked to create player form");
        return "profile/create-player";
    }

    @GetMapping("/top-up")
    public String topUpForm() {
        log.info("Clicked to top up");
        return "profile/top-up";
    }

    @GetMapping("/make-bet")
    public String betForm() {
        log.info("Clicked to make a bet");
        return "profile/make-bet";
    }

    @PostMapping("/create-player")
    public String createPlayer(Player player) {
        playerService.registerPlayer(player);
        log.info("Player created '{}'", player.getName());
        return "redirect:/";
    }

    @PostMapping("/top-up")
    public String topUpAccount(Integer userId, Double amount) {
        // todo: checks for amount lower than zero? |  may be checks should be in html code?
        var user = userService.getUserById(userId);
        log.info("'{}' balance '{}' before replenishment", user.getUsername(), user.getBalance());
        userService.updateBalance(user, amount);
        log.info("'{}' balance '{}' after replenishment", user.getUsername(), user.getBalance());
        return "redirect:/";
    }
}
