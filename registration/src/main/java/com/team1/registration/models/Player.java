package com.team1.registration.models;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue
    @Column(name = "player_id")
    private Integer id;

    @Column(name = "player_name", nullable = false)
    private String name;

    @Column(name = "team_id")
    private int teamId;

    @Column(name = "player_password", nullable = false)
    private String password;

    @Column(name = "player_balance", nullable = false)
    private String balance;
}
