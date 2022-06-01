package com.team1.registration.controllers.player;

import com.team1.registration.models.Player;
import com.team1.registration.models.User;
import com.team1.registration.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class PlayerController {
    private PlayerService playerService;

    @PostMapping("/players/new")
    public void registerPlayer(Player player, Map<String, Object> model) {

    }

}
