package com.challenge.Service.impl;

import com.challenge.DTO.GenreDTO;

import com.challenge.Entity.GenreEntity;
import com.challenge.Repository.GenreRepository;

import com.challenge.Service.GenreService;
import com.challenge.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;
    private GenreRepository genreRepository;

    public GenreDTO save(GenreDTO dto) {

        GenreEntity entity = genreMapper.genreDTO2Entity(dto);
        GenreEntity entitySaved = genreRepository.save(entity);
        GenreDTO result = genreMapper.genreEntity2DTO(entitySaved);
        return result;
    }

    public List<GenreDTO> getAllGenres(){
        List<GenreEntity> entities = this.genreRepository.findAll();
        List<GenreDTO> result = this.genreMapper.genreEntityList2DTOList(entities);
        return result;

    }
    public void delete(Long id){
        this.genreRepository.deleteById(id);
    }

}
