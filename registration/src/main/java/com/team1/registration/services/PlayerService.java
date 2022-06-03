package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        return playerRepository.findById(playerId).orElseThrow(() -> new NoSuchElementException(String.valueOf(playerId)));
    }

    public void updatePlayer(Player player) {
        log.info(String.format("Updated to '%s'", player));
        playerRepository.save(player);
    }

    public boolean containsPlayer(Integer playerId) {
        return playerRepository.existsById(playerId);
    }

    public void addTeamToPlayer(Player player, Team team){
        player.getTeams().add(team);
    }

    public List<Player> getPlayersByUserId(Integer userId) {
        log.info("Getting all players by usedId '{}'", userId);
        return playerRepository.getPlayersByUserId(userId);
    }
}
