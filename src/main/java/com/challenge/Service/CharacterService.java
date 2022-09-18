package com.challenge.Service;

import com.challenge.DTO.CharacterDTO;

import java.util.List;
import java.util.Set;

public interface CharacterService {

	CharacterDTO save(CharacterDTO dto);
	List<CharacterDTO> getAllCharacters();
	//CharacterDTO update(Long id, CharacterDTO character);
	void delete(Long id);

   	CharacterDTO getDetailsById(Long id);

	List<CharacterDTO> getByFilters(String name,Integer age, Set<Long> movies, String order);

	//CharacterDTO updateCharacter (Long id,CharacterDTO dto );

}
