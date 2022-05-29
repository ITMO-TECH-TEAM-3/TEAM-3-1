package com.team1.registration.services;

import com.team1.registration.models.Player;
import com.team1.registration.models.Team;
import com.team1.registration.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;
    private PlayerService playerService;

    public void registerTeam(Team team) {
        teamRepository.save(team); //todo: check data for correctness
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Integer teamId){
        for (Team team:
                getAllTeams()) {
            if (team.getId() == teamId){
                return team;
            }
        }

        return null;
    }

    public void addNewPlayer(Integer teamId, Integer playerId){
        Team team = getTeamById(teamId);
        Player player = playerService.getPlayerById(playerId);
        team.getPlayers_id().add(player);
    }
}
