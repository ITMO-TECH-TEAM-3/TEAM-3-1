package com.team1.registration.models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    // todo: Add other user fields
    private int id;
    private String name;
}
