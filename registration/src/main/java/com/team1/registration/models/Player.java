package com.team1.registration.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    /*
        todo: @OneToMany ? @ManyToMany / @ManyToOne
        how to connect teams and players
     */
    @JoinColumn(name = "team")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Team team;

    @Column(name = "balance", nullable = false)
    private String balance;

    @Column(name = "user_id")
    private Integer userId;
}
