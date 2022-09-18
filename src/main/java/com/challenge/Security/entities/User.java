package com.challenge.Security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @Column(unique = true)
    private String userName;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name= "user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    private transient Set<Role> roles = new HashSet<>();

}
