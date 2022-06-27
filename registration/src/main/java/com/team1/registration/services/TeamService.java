package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.models.dto.TeamDto;
import com.team1.registration.repositories.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Slf4j
public class TeamService {
    private final TeamRepository teamRepository;
    private final PlayerService playerService;

    public TeamService(TeamRepository repo, @Lazy PlayerService serv) {
        teamRepository = repo;
        playerService = serv;
    }

    public void registerTeam(TeamDto teamDto) {
        var creatorId = teamDto.getCreatorId();
        if (!playerService.containsPlayer(creatorId)) {
            throw new NoSuchElementException(String.format("Player with '%s' doesn't exist!", creatorId));
        }
        var team = new Team().toBuilder()
                .name(teamDto.getName())
                .creatorId(creatorId)
                .build();
        log.info("Team registration '{}'", team.getName());
        teamRepository.save(team);
        playerService.joinTeam(playerService.getPlayerById(creatorId), team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(UUID teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new NoSuchElementException(String.format("Team with '%s' doesn't exist!", teamId)));
    }

    public void updateTeam(Team team) {
        log.info("Updating team '{}'", team.getName());
        teamRepository.save(team);
    }

    public void addPlayerToTeam(Team team, Player player) {
        team.getPlayers().add(player);
    }

    public void deleteTeam(UUID teamId) {
        log.info("Deleting team '{}'", teamId);
        teamRepository.delete(this.getTeamById(teamId));
    }
}
