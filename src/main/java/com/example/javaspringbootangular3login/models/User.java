package com.example.javaspringbootangular3login.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public User() {
    }

    public User(String email, String fistName, String lastName, String password) {
        this.email = email;
        this.firstName = fistName;
        this.lastName = lastName;
        this.password = password;
    }
}
