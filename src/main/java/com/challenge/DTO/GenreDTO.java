package com.challenge.DTO;

import com.challenge.Entity.MovieEntity;

import lombok.Data;

@Data
public class GenreDTO {

	private Long id;
	private String name;
	private String image;
	private MovieEntity movie;
	private Long movieId;
}
