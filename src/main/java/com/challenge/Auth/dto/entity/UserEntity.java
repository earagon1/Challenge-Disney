package com.challenge.Auth.dto.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", unique=true, nullable=false)
    private Long characterId;

    @Column(name="username")
    @Email(message="Username must be an email")
    private String userName;

    @Column(name = "password")
    @Size(min =0)
    private String password;

}
