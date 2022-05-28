package com.team1.registration.controllers;

import com.team1.registration.models.Player;
import com.team1.registration.repositories.PlayerRepository;
import com.team1.registration.services.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

public class RegisterUserPageController {
    private PlayerRepository playerRepository;

    @GetMapping("/register")
    public String register(){
        return "";
    }

    @PostMapping("/register")
    public String registerUser(Player player, Map<String, Object> model){
        Player playerFromDb = playerRepository.findByName(player.getName());
        if(playerFromDb != null){
            model.put("message", "User exists");
            return "/register";
        }
        player.setActive(true);
        playerRepository.save(player);
        return "redirect:/login";
    }
}
