package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    private PlayerRepository playerRepository;

    public void registerPlayer(Player player) {
        //todo: check data for correctness
        playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
