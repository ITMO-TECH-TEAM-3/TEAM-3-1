package com.team1.registration.models;

import java.util.LinkedList;
import java.util.List;

public class PlayerStatistics {
    private final Player player;

    public PlayerStatistics(Player player){
        this.player = player;
    }

    public Integer getTeamId(){
        return player.getTeam().getId();
    }

    public double getBalance(){
        return Double.parseDouble(player.getBalance());
    }

    public Boolean isBalanceZero(){
        return getBalance() == 0;
    }

    public Boolean isBalanceNegative(){
        return getBalance() < 0;
    }

    public List<PlayerStatistics> TeamMembersStatistics(){
        List<PlayerStatistics> list = new LinkedList<PlayerStatistics>();
        for (Player p:
             player.getTeam().getPlayersId()) {
            list.add(new PlayerStatistics(p));
        }

        return list;
    }

    /*
    public MatchStatistics matchInfo(){
        todo: extract info from the team's matches
    }
    */
}
