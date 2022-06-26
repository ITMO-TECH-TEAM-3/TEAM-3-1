package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.models.dto.PlayerDto;
import com.team1.registration.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Slf4j
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamService teamService;

    public PlayerService(PlayerRepository repo, @Lazy TeamService serv) {
        playerRepository = repo;
        teamService = serv;
    }

    public void registerPlayer(PlayerDto playerDto) {
        var player = new Player().toBuilder()
                .name(playerDto.getName())
                .userId(playerDto.getUserId())
                .build();
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
