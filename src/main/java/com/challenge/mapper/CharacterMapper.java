package com.challenge.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.challenge.DTO.CharacterDTO;
import com.challenge.Entity.CharacterEntity;

@Component
public class CharacterMapper {
	
	public CharacterEntity characterDTO2Entity(CharacterDTO dto) {
		
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setCharacterName(dto.getName());
		characterEntity.setCharacterAge(dto.getAge());
		characterEntity.setCharacterHistory(dto.getHistory());
		characterEntity.setCharacterImage(dto.getImage());
		characterEntity.setCharacterWeigth(dto.getWeigth());
		//characterEntity.setMovies(dto.getMovies()); PREGUNTAR COMO SE HACE EL SET DE MOVIES
		return characterEntity;
	}

	public CharacterDTO characterEntity2DTO(CharacterEntity entity) {
		CharacterDTO characterDTO = new CharacterDTO();
		characterDTO.setName(entity.getCharacterName());
		characterDTO.setAge(entity.getCharacterAge());
		characterDTO.setHistory(entity.getCharacterHistory());
		characterDTO.setImage(entity.getCharacterImage());
		characterDTO.setWeigth(entity.getCharacterWeigth());
		//characterDTO.setMovies(entity.getMovies()); PREGUNTAR COMO SE HACE EL SET DE MOVIES;
		return characterDTO;
	}
	
	public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities){
		
		List<CharacterDTO> dtos = new ArrayList<>();
		for (CharacterEntity entity:entities) {
			dtos.add(this.characterEntity2DTO(entity));
		}
		return dtos;
	}
}
