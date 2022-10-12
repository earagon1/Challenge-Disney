package com.challenge.Controller;

import com.challenge.DTO.CharacterDTO;
import com.challenge.DTO.GenreDTO;

import com.challenge.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genre")
public class GenreController {
	
	@Autowired
	private GenreService genreService;


	@PostMapping
	public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genre){
		GenreDTO genreSave = genreService.save(genre);
		return ResponseEntity.status(HttpStatus.CREATED).body(genreSave);
	}

	/*
	@GetMapping("/{id}")
	public ResponseEntity<GenreDTO> getDetailById(@PathVariable Long id){
		GenreDTO genre = this.genreService.getDetailsById(id);
		return ResponseEntity.ok(genre);
	}

	@GetMapping
	public ResponseEntity<List<GenreDTO>> getAll(){
		List<GenreDTO> genres = genreService.getAllGenres();
		return ResponseEntity.ok().body(genres);

	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.genreService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
*/


}
