package com.team1.registration.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    /*
        todo: @OneToMany ? @ManyToMany / @ManyToOne
        how to connect teams and players
     */

    @JoinColumn(name = "team_id")
    @ManyToOne
    private Team team;

    @Column(nullable = false)
    private String balance;

    private Integer userId;
}
