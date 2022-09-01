package com.challenge.Service;

import java.util.List;

import com.challenge.DTO.CharacterDTO;

public interface CharacterService {

	CharacterDTO save(CharacterDTO dto);
	List<CharacterDTO> getAllCharacters(); 
}
