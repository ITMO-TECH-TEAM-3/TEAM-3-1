package com.team1.registration.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    // todo: Add other team fields

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Integer id;

    @Column(name = "team_name", nullable = false)
    private String name;
}
