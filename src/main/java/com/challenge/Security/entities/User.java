package com.challenge.Security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
