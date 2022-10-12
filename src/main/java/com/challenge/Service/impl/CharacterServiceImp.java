package com.challenge.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.challenge.DTO.CharacterFiltersDTO;
import com.challenge.Repository.Specification.CharacterSpecification;
import com.challenge.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.DTO.CharacterDTO;
import com.challenge.Entity.CharacterEntity;
import com.challenge.Repository.CharacterRepository;
import com.challenge.Service.CharacterService;
import com.challenge.mapper.CharacterMapper;

@Service
public class CharacterServiceImp implements CharacterService {

	private CharacterRepository characterRepository;
	private CharacterSpecification characterSpecification;
	private CharacterMapper characterMapper;
	private MovieService movieService;

	@Autowired
	public  CharacterServiceImp(CharacterRepository characterRepository,
								CharacterSpecification characterSpecification,
								CharacterMapper characterMapper,
								MovieService movieService){
		this.characterRepository=characterRepository;
		this.characterSpecification=characterSpecification;
		this.characterMapper=characterMapper;
		this.movieService= movieService;
	}

	//para el post
	public CharacterDTO save(CharacterDTO dto) {
		CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
		CharacterEntity entitySaved = characterRepository.save(entity);
		CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved,true);
		return result; 
	}

	//para traer todos los character
	public List<CharacterDTO> getAllCharacters(){
		List<CharacterEntity> entities = this.characterRepository.findAll();
		List<CharacterDTO> result = this.characterMapper.characterEntityList2DTOList(entities,true);
		return result;
	}

	//cambiarle el nombre a getCharacterByID, trae un character por id
	public CharacterDTO getDetailsById(Long id){
		Optional<CharacterEntity> entity= this.characterRepository.findById(id);
		if(!entity.isPresent()){
			throw new RuntimeException("Id character no valido"); //ParamNotFound
		}
		CharacterDTO characterDTO = this.characterMapper.characterEntity2DTO(entity.get(),true);//ver el boolean de characterEntity2DTO
		return characterDTO;
	}

/******/
	public void delete(Long id){
		this.characterRepository.deleteById(id);
	}

	public List<CharacterDTO> getByFilters(String name,Integer age, Set<Long> movies, String order){
		CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age ,movies, order);
		List<CharacterEntity> entities = this.characterRepository.findAll(this.characterSpecification.getByFilters(filtersDTO));
		List<CharacterDTO> dtos = this.characterMapper.characterEntitySet2DTOList(entities,true);
		return dtos;
	}

}
