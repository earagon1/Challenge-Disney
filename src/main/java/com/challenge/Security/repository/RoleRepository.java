package com.challenge.Security.repository;

import com.challenge.Security.entities.Role;
import com.challenge.Security.enums.RoleList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role, Integer> {
    Optional<Role> findByRoleName(RoleList roleName);

}