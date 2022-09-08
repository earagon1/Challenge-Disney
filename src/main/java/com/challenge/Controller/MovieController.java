package com.challenge.Controller;

import com.challenge.DTO.CharacterDTO;
import com.challenge.DTO.MovieDTO;
import com.challenge.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getDetailById(@PathVariable Long id){
		MovieDTO movie = this.movieService.getDetailsById(id);
		return ResponseEntity.ok(movie);
	}

	@GetMapping("/list")
	public ResponseEntity<List<MovieDTO>> getAll(){
		List<MovieDTO> movies = movieService.getAllMovies();
		return ResponseEntity.ok().body(movies);
	}

	@GetMapping
	public ResponseEntity<List<MovieDTO>>  getDetailsByfilters(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Long idGenre,
			@RequestParam(required = false , defaultValue = "ASC") String order
	){
		List<MovieDTO> movies = this.movieService.getByFilters(name, idGenre,order);
		return ResponseEntity.ok(movies);
	}

	@PostMapping
	public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
		MovieDTO movieSave = movieService.save(movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieSave);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.movieService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}


}
