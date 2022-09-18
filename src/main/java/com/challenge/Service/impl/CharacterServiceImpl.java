package com.challenge.Service.impl;

import com.challenge.DTO.CharacterDTO;
import com.challenge.DTO.CharacterFiltersDTO;
import com.challenge.Repository.CharacterRepository;
import com.challenge.Entity.CharacterEntity;
import com.challenge.Service.MovieService;
import com.challenge.Specification.CharacterSpecification;
import com.challenge.Service.CharacterService;
import com.challenge.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

	private CharacterRepository characterRepository;
	private CharacterSpecification characterSpecification;
	private CharacterMapper characterMapper;
	private MovieService movieService;

	@Autowired
	public CharacterServiceImpl(CharacterRepository characterRepository,
                                CharacterSpecification characterSpecification,
                                CharacterMapper characterMapper,
                                MovieService movieService){
		this.characterRepository=characterRepository;
		this.characterSpecification=characterSpecification;
		this.characterMapper=characterMapper;
		this.movieService= movieService;
	}
	
	public CharacterDTO save(CharacterDTO dto) {
		
		CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
		CharacterEntity entitySaved = characterRepository.save(entity);
		CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved,true);
		return result; 
	}
	
	public List<CharacterDTO> getAllCharacters(){
		List<CharacterEntity> entities = this.characterRepository.findAll();
		List<CharacterDTO> result = this.characterMapper.characterEntityList2DTOList(entities,true);
		return result;
	}

	public void delete(Long id){
		this.characterRepository.deleteById(id);
	}

	/*public CharacterDTO updateCharacter (Long id,CharacterDTO dto ){

	}*/
	public CharacterDTO getDetailsById(Long id){
		Optional<CharacterEntity> entity= this.characterRepository.findById(id);
		if(!entity.isPresent()){
			throw new RuntimeException("Id character no valido"); //ParamNotFound
		}
		CharacterDTO characterDTO = this.characterMapper.characterEntity2DTO(entity.get(),true);
		return characterDTO;
	}

	public List<CharacterDTO> getByFilters(String name,Integer age, Set<Long> movies, String order){
		CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age ,movies, order);
		List<CharacterEntity> entities = this.characterRepository.findAll(this.characterSpecification.getByFilters(filtersDTO));
		List<CharacterDTO> dtos = this.characterMapper.characterEntitySet2DTOList(entities,true);
		return dtos;
	}


}
