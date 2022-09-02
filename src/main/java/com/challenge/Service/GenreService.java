package com.challenge.Service;

import com.challenge.DTO.GenreDTO;

import java.util.List;

public interface GenreService {
    GenreDTO save(GenreDTO dto);
    List<GenreDTO> getAllGenres();
}
