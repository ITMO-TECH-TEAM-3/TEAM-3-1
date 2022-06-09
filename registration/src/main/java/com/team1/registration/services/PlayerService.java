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
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerService {
    private PlayerRepository playerRepository;
    private TeamService teamService;

    public void registerPlayer(Player player) {
        //todo: check data for correctness
        playerRepository.save(player);
        log.info("Register '{}'", player.getName());
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(UUID playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException(playerId.toString()));
    }

    public void updatePlayer(Player player) {
        playerRepository.save(player);
        log.debug("Player '{}' updated", player.getName());
    }

    public boolean containsPlayer(UUID playerId) {
        return playerRepository.existsById(playerId);
    }

    public void addTeamToPlayer(Player player, Team team) {
        player.getTeams().add(team);
    }

    public void joinTeam(Player player, Team team) {
        teamService.addPlayerToTeam(team, player);
        teamService.updateTeam(team);
        this.addTeamToPlayer(player, team);
        this.updatePlayer(player);
        log.info("Player '{}' joined to team '{}'", player.getName(), team.getName());
    }

    public List<Player> getPlayersByUserId(UUID userId) {
        // todo: add checks
        return playerRepository.getPlayersByUserId(userId);
    }
}
