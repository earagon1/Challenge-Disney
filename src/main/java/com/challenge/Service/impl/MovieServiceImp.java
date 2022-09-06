package com.challenge.Service.impl;

import com.challenge.DTO.MovieDTO;
import com.challenge.Entity.MovieEntity;
import com.challenge.Repository.MovieRepository;
import com.challenge.Service.MovieService;
import com.challenge.mapper.MovieMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved, true);
        return result;
    }

    public List<MovieDTO> getAllMovies(){
        List<MovieEntity> entities = this.movieRepository.findAll();
        List<MovieDTO> result = this.movieMapper.movieEntityList2DTOList(entities, true);
        return result;

    }

    public MovieDTO getDetailsById(Long id){
		Optional<MovieEntity> entity= this.movieRepository.findById(id);
		if(!entity.isPresent()){
			throw new RuntimeException("Id movie no valido"); //ParamNotFound
		}
		MovieDTO characterDTO = this.movieMapper.movieEntity2DTO(entity.get(),true);//ver el boolean de characterEntity2DTO
		return characterDTO;
	}

    public void delete(Long id){
        this.movieRepository.deleteById(id);
    }

}
