package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerService {
    private PlayerRepository playerRepository;

    public void registerPlayer(Player player) {
        //todo: check data for correctness
        log.info(String.format("Register '%s'", player));
        playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Integer playerId) {
        // todo: check player for existing with orElse(() -> throw ...)
        return playerRepository.findById(playerId).orElse(null);
    }

    public void updatePlayer(Player player) {
        log.info(String.format("Updated to '%s'", player));
        playerRepository.save(player);
    }
}
