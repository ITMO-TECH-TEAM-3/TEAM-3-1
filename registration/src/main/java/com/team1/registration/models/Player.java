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
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "teamId")
    private int teamId;

    @Column(name = "balance", nullable = false)
    private String balance;

    @Column(name = "userId")
    private int userId;
}
