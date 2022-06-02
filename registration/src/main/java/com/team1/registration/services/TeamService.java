package com.team1.registration.services;

import com.team1.registration.models.Team;
import com.team1.registration.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Slf4j
public class TeamService {
    private TeamRepository teamRepository;

    public void registerTeam(Team team) {
        //todo: check data for correctness
        log.info(String.format("Register '%s'", team));
        teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Integer teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new NoSuchElementException(String.valueOf(teamId)));
    }

    public void updateTeam(Team team) {
        log.info(String.format("Updated to '%s'", team));
        teamRepository.save(team);
    }
}
