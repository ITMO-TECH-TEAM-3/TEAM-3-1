package com.team1.registration.models;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "teamId")
    private int teamId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "balance", nullable = false)
    private String balance;

    private boolean active;

}
