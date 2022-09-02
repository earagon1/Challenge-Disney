package com.challenge.mapper;

import com.challenge.DTO.GenreDTO;
import com.challenge.Entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreMapper {

    public GenreEntity genreDTO2Entity(GenreDTO dto) {

        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenreName(dto.getName());
        genreEntity.setGenreImage(dto.getImage());
        //characterEntity.setMovies(dto.getMovies()); PREGUNTAR COMO SE HACE EL SET DE MOVIES
        return genreEntity;
    }

    public GenreDTO genreEntity2DTO(GenreEntity entity) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setName(entity.getGenreName());
        genreDTO.setImage(entity.getGenreImage());
        //characterDTO.setMovies(entity.getMovies()); PREGUNTAR COMO SE HACE EL SET DE MOVIES;
        return genreDTO;
    }

    public List<GenreDTO> genreEntityList2DTOList(List<GenreEntity> entities){

        List<GenreDTO> dtos = new ArrayList<>();
        for (GenreEntity entity:entities) {
            dtos.add(this.genreEntity2DTO(entity));
        }
        return dtos;
    }
}
