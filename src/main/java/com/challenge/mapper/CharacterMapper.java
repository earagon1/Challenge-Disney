package com.challenge.mapper;

import java.util.*;

import com.challenge.DTO.CharacterBasicDTO;
import com.challenge.DTO.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.DTO.CharacterDTO;
import com.challenge.Entity.CharacterEntity;

@Component
public class CharacterMapper {

	@Autowired
	private MovieMapper movieMapper;

	//lo usa el post
	public CharacterEntity characterDTO2Entity(CharacterDTO dto) {//, boolean loadMovies
		CharacterEntity characterEntity = new CharacterEntity();
		characterEntity.setCharacterName(dto.getName());
		characterEntity.setCharacterAge(dto.getAge());
		characterEntity.setCharacterStory(dto.getStory());
		characterEntity.setCharacterImage(dto.getImage());
		characterEntity.setCharacterWeigth(dto.getWeigth());
		//characterEntity.setMovies(dto.getMovies());
		/*if(!loadMovies){
			List<MovieDTO> moviesDTO = this.movieMapper.movieEntityList2DTOList(dto.getMovies(), false);
			characterEntity.setMovies(moviesDTO);
		}*/
		return characterEntity;
	}
	
	public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies) {
		CharacterDTO dto = new CharacterDTO();
		dto.setId(entity.getCharacterId());
		dto.setName(entity.getCharacterName());
		dto.setAge(entity.getCharacterAge());
		dto.setStory(entity.getCharacterStory());
		dto.setImage(entity.getCharacterImage());
		dto.setWeigth(entity.getCharacterWeigth());
		if(loadMovies){
			List<MovieDTO> moviesDTO = this.movieMapper.movieEntityList2DTOList(entity.getMovies(),false);
			dto.setMovies(moviesDTO);
		}
		return dto;
	}

  	public void characterEntityRefreshValue(CharacterEntity entity, CharacterDTO characterDTO){
		entity.setCharacterName(characterDTO.getName());
		entity.setCharacterImage(characterDTO.getImage());
		entity.setCharacterAge(characterDTO.getAge());
		entity.setCharacterStory(characterDTO.getStory());
  	}

	public Set<CharacterEntity> characterDTOList2Entity(List<CharacterDTO> dtos){//,  boolean loadMovies
		Set<CharacterEntity> entities = new HashSet<>();
		for(CharacterDTO dto : dtos){
			entities.add(this.characterDTO2Entity(dto));//,loadMovies
		}
		return entities;
	}

	public List<CharacterDTO> characterEntitySet2DTOList(Collection<CharacterEntity> entities, boolean loadMovies){
		List<CharacterDTO> dtos = new ArrayList<>();
		for(CharacterEntity entity :entities){
			dtos.add(this.characterEntity2DTO(entity, loadMovies));
		}
		return dtos;
	}

	public List<CharacterBasicDTO> characterEntitySet2BasicDTOList(Collection<CharacterEntity> entities){
		List<CharacterBasicDTO> dtos = new ArrayList<>();
		CharacterBasicDTO basicDTO;
		for(CharacterEntity entity : entities){
			basicDTO = new CharacterBasicDTO();
			basicDTO.setId(entity.getCharacterId());
			basicDTO.setName(entity.getCharacterName());
			dtos.add(basicDTO);
		}
		return dtos;
	}

	//para el getall
	public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities,  boolean loadMovies){
		
		List<CharacterDTO> dtos = new ArrayList<>();
		for (CharacterEntity entity:entities) {
			dtos.add(this.characterEntity2DTO(entity,loadMovies));
		}
		return dtos;
	}

}












