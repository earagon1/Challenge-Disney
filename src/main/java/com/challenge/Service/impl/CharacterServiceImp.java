package com.challenge.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.DTO.CharacterDTO;
import com.challenge.Entity.CharacterEntity;
import com.challenge.Repository.CharacterRepository;
import com.challenge.Service.CharacterService;
import com.challenge.mapper.CharacterMapper;

@Service
public class CharacterServiceImp implements CharacterService {

	@Autowired
	private CharacterMapper characterMapper;
	private CharacterRepository characterRepository;
	
	public CharacterDTO save(CharacterDTO dto) {
		
		CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
		CharacterEntity entitySaved = characterRepository.save(entity);
		CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved);
		return result; 
	}
	
	public List<CharacterDTO> getAllCharacters(){
		List<CharacterEntity> entities = this.characterRepository.findAll();
		List<CharacterDTO> result = this.characterMapper.characterEntityList2DTOList(entities);
		return result; 
		
	}
}
