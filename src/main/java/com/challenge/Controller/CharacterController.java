package com.challenge.Controller;

import com.challenge.DTO.CharacterDTO;
import com.challenge.Repository.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("character")
public class CharacterController {

	@Autowired
	private CharacterService characterService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CharacterDTO> getDetailById(@PathVariable Long id){
		CharacterDTO character = this.characterService.getDetailsById(id);
		return ResponseEntity.ok(character);
	}


	@GetMapping("/list")
	public ResponseEntity<List<CharacterDTO>> getAll(){
		List<CharacterDTO> characters = characterService.getAllCharacters();
		return ResponseEntity.ok().body(characters);
		
	}

	@GetMapping
	public ResponseEntity<List<CharacterDTO>>  getDetailsByfilters(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Set<Long> movies,
			@RequestParam(required = false , defaultValue = "ASC") String order
			){
		List<CharacterDTO> characters = this.characterService.getByFilters(name, age,movies, order);
		return ResponseEntity.ok(characters);
	}
	
	@PostMapping
	public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){
		CharacterDTO characterSave = characterService.save(character);
		return ResponseEntity.status(HttpStatus.CREATED).body(characterSave);
	}

	/*@PutMapping("/characterId")
	public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable("characterId") Long characterId,@RequestBody CharacterDTO characterDTO) {
		CharacterDTO characterUpDto=characterService.updateCharacter(characterId,characterDTO);
		return ResponseEntity.status(HttpStatus.OK).body(characterUpDto);
	}*/


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.characterService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
