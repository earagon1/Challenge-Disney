package com.challenge.mapper;

import com.challenge.DTO.MovieDTO;
import com.challenge.Entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity(MovieDTO dto) {

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setMovieImage(dto.getImage());
        movieEntity.setMovieCreation(dto.getCreation());
        movieEntity.setMovieTitle(dto.getTitle());
        movieEntity.setQualification(dto.getQualification());
        movieEntity.setGenre(dto.getGenre());
        //movieEntity.setCharacters(dto.getCharacters());

        return movieEntity;

    }

    public MovieDTO movieEntity2DTO(MovieEntity entity) {

        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setImage(entity.getMovieImage());
        movieDTO.setTitle(entity.getMovieTitle());
        movieDTO.setCreation(entity.getMovieCreation());
        movieDTO.setQualification(entity.getQualification());
        movieDTO.setGenre(entity.getGenre());
        //movieDTO.setCharacters(entity.getCharacters()); 
        return movieDTO;

    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities){

        List<MovieDTO> dtos= new ArrayList<>();
        for (MovieEntity entity:entities) {
            dtos.add(this.movieEntity2DTO(entity));
        }
        return dtos;
    }

}
