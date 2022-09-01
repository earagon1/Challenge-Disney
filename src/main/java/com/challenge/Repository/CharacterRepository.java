package com.challenge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.Entity.CharacterEntity;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity,Long> {

}
