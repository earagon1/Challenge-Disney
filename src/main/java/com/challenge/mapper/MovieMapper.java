package com.challenge.mapper;

import com.challenge.DTO.CharacterDTO;
import com.challenge.DTO.MovieDTO;
import com.challenge.Entity.CharacterEntity;
import com.challenge.Entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    @Autowired
    private CharacterMapper characterMapper;

     public MovieEntity movieDTO2Entity(MovieDTO dto) {

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setMovieImage(dto.getImage());
        movieEntity.setMovieCreation(dto.getCreation());
        movieEntity.setMovieTitle(dto.getTitle());
        movieEntity.setQualification(dto.getQualification());
        movieEntity.setGenre(dto.getGenre());
        return movieEntity;

    }
/*
   public MovieDTO movieEntity2DTO(MovieEntity entity) {

        MovieDTO dto = new MovieDTO();
        dto.setImage(entity.getMovieImage());
        dto.setTitle(entity.getMovieTitle());
        dto.setCreation(entity.getMovieCreation());
        dto.setQualification(entity.getQualification());
        dto.setGenre(entity.getGenre());

        return dto;

    }


    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities){

        List<MovieDTO> dtos= new ArrayList<>();
        for (MovieEntity entity:entities) {
            dtos.add(this.movieEntity2DTO(entity));
        }
        return dtos;
    }
*/

    public MovieDTO movieEntity2DTO(MovieEntity entity,boolean loadCharacters) {

        MovieDTO dto = new MovieDTO();
        dto.setImage(entity.getMovieImage());
        dto.setTitle(entity.getMovieTitle());
        dto.setCreation(entity.getMovieCreation());
        dto.setQualification(entity.getQualification());
        dto.setGenre(entity.getGenre());
        if(loadCharacters){
            List<CharacterDTO> charactersDTOS= this.characterMapper.characterEntitySet2DTOList(entity.getCharacters(),false);
            dto.setCharacters(charactersDTOS);
        }
        return dto;

    }


    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters){
        List<MovieDTO> dtos =new ArrayList<>();
        for(MovieEntity entity : entities){
            dtos.add(this.movieEntity2DTO(entity,loadCharacters));
        }
        return dtos;
    }

    public List<MovieEntity> movieDTOList2Entity(List<MovieDTO> dtos){
        List<MovieEntity> entities = new ArrayList<>();
        for(MovieDTO dto : dtos){
            entities.add(this.movieDTO2Entity(dto));
        }
        return entities;
    }

    public List<MovieDTO> movieEntitySet2DTOList(List<MovieEntity> entities, boolean loadCharacters) {

        List<MovieDTO> dtos = new ArrayList<>();
        for(MovieEntity entity :entities){
            dtos.add(this.movieEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }
}
