package com.challenge.Controller;

import java.util.List;
import java.util.Set;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challenge.DTO.CharacterDTO;
import com.challenge.Service.CharacterService;
import com.challenge.Service.impl.CharacterServiceImp;

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


	@GetMapping
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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.characterService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
