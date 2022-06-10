package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class TeamService {
    private TeamRepository teamRepository;

    public void registerTeam(Team team) {
        //todo: check data for correctness
        log.info("Team registration '{}'", team.getName());
        teamRepository.save(team);
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
