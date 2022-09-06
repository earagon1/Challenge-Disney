package com.challenge.Service;

import com.challenge.DTO.CharacterDTO;
import com.challenge.DTO.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    void delete(Long id);
    MovieDTO getDetailsById(Long id);
}
