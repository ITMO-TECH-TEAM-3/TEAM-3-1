package com.team1.registration.models;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    // todo: Add other user fields

    @Id
    @GeneratedValue
    @Column(name = "player_id")
    private Integer id;

    @Column(name = "player_name", nullable = false)
    private String name;
}
