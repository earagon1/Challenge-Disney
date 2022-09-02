package com.challenge.Controller;

import com.challenge.DTO.MovieDTO;
import com.challenge.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAll(){
		List<MovieDTO> movies = movieService.getAllMovies();
		return ResponseEntity.ok().body(movies);

	}

	@PostMapping
	public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
		MovieDTO movieSave = movieService.save(movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieSave);
	}


}
