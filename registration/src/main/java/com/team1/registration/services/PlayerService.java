package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    // can be removed ???
    public void updatePlayer(Integer playerId, Player player) {
        var updatedPlayer = playerRepository.getById(playerId).toBuilder()
                .balance(player.getBalance())
                .team(player.getTeam())
                .name(player.getName())
                .build();

        playerRepository.save(updatedPlayer);
    }

    public Player getPlayerById(Integer playerId) {
        // todo: throw exception
        return playerRepository.findById(playerId).orElse(null);
    }
}
