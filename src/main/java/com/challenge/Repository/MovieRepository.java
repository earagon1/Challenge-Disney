package com.challenge.Repository;

import com.challenge.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
}
