package com.challenge.Service;

import java.util.List;
import java.util.Set;

import com.challenge.DTO.CharacterDTO;

public interface CharacterService {

	CharacterDTO save(CharacterDTO dto);
	List<CharacterDTO> getAllCharacters();
	//CharacterDTO update(Long id, CharacterDTO character);
	void delete(Long id);

   CharacterDTO getDetailsById(Long id);

	List<CharacterDTO> getByFilters(String name,Integer age, Set<Long> movies, String order);
}
