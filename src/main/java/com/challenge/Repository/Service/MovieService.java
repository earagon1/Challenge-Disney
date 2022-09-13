package com.challenge.Repository.Service;

import com.challenge.DTO.CharacterDTO;
import com.challenge.DTO.MovieDTO;

import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO save(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    void delete(Long id);
    MovieDTO getDetailsById(Long id);
    List<MovieDTO> getByFilters(String name, Long idGenre, String order);
}
