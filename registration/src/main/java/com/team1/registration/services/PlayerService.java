package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        log.info("Player registration '{}'", player.getName());
        playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(UUID playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Player with '%s' doesn't exist!", playerId)));
    }

    public void updatePlayer(Player player) {
        log.debug("Updating '{}'", player.getName());
        playerRepository.save(player);
    }

    public boolean containsPlayer(UUID playerId) {
        return playerRepository.existsById(playerId);
    }

    public void addTeamToPlayer(Player player, Team team) {
        player.getTeams().add(team);
    }

    public void joinTeam(Player player, Team team) {
        log.info("Player '{}' joining to team '{}'", player.getName(), team.getName());
        teamService.addPlayerToTeam(team, player);
        teamService.updateTeam(team);
        this.addTeamToPlayer(player, team);
        this.updatePlayer(player);
    }

    public List<Player> getPlayersByUserId(UUID userId) {
        return playerRepository.getPlayersByUserId(userId);
    }

    public void deletePlayer(UUID playerId) {
        log.info("Deleting player '{}'", playerId);
        playerRepository.delete(this.getPlayerById(playerId));
    }
}
