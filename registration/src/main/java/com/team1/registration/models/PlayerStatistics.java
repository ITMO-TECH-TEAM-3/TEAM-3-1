package com.team1.registration.models;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class PlayerStatistics {

    // todo: add other statistics fields
    public PlayerStatistics() {
        kills = 0;
    }

    private Integer kills;

    // todo: update fields data from another microservice
}
