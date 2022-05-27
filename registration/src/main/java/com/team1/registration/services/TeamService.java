package com.team1.registration.services;

import com.team1.registration.models.Team;
import com.team1.registration.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;

    public void registerTeam(Team team) {
        //todo: check data for correctness
        teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }
}
