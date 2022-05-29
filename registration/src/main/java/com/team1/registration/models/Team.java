package com.team1.registration.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    // todo: understand where this field is assigned
    @Column(name = "creator_id", nullable = false)
    private Integer creatorId;


    /*
        todo: @OneToMany ? @ManyToMany / @ManyToOne
        how to connect teams and players
     */
//    @OneToMany
//    private List<Player> players;
}
