package com.challenge.Repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.challenge.Repository.Entity.CharacterEntity;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity,Long>, JpaSpecificationExecutor<CharacterEntity> {

    List<CharacterEntity> findAll(Specification<CharacterEntity> spec);

}
