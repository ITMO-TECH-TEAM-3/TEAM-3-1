package com.team1.registration.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "players")
public class Player {
    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "players")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Team> teams = new HashSet<>();

    private UUID userId;

    @Embedded
    private PlayerStatistics playerStatistics = new PlayerStatistics();
}
