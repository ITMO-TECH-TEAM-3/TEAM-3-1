package com.team1.registration.controllers.player;


import com.team1.registration.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    //todo: move createPlayer from ProfileService here

    //fixme: do it without @PathVariable
    @GetMapping("{userId}")
    public ModelAndView getAllUserPlayers(@PathVariable Integer userId) {
        var players = playerService.getPlayersByUserId(userId);
        var modelAndView = new ModelAndView();
        modelAndView.addObject("players", players);
        modelAndView.setViewName("players/getAllPlayers");
        return modelAndView;
    }
}
