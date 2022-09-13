package com.challenge.Repository.Service;

import com.challenge.DTO.GenreDTO;

import java.util.List;

public interface GenreService {
    GenreDTO save(GenreDTO dto);
    List<GenreDTO> getAllGenres();
    void delete(Long id);
    GenreDTO getDetailsById(Long id);
}
