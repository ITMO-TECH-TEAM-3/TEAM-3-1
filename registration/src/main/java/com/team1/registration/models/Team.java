package com.team1.registration.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "teams")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    // todo: understand where this field is assigned
    @Column(nullable = false)
    private Integer creatorId;


    /*
        todo: @OneToMany ? @ManyToMany / @ManyToOne
        how to connect teams and players
     */
    @OneToMany(mappedBy = "team")
    private List<Player> playersId;
}
