package com.challenge.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.DTO.CharacterDTO;
import com.challenge.Service.CharacterService;

@RestController
@RequestMapping("character")
public class CharacterController {

	@Autowired
	private CharacterService characterService;
	
	@PostMapping
	public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){
		//CharacterDTO characterSave = characterService.save(character);
		return ResponseEntity.status(HttpStatus.CREATED).body(/*characterSave*/character);
	}
}
