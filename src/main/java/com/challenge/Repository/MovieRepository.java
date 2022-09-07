package com.challenge.Repository;

import com.challenge.Entity.CharacterEntity;
import com.challenge.Entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Long>, JpaSpecificationExecutor<MovieEntity> {
    List<MovieEntity> findAll(Specification<MovieEntity> spec);
}
