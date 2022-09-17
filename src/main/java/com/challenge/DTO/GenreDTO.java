package com.challenge.DTO;

import com.challenge.Repository.Entity.MovieEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

	private String id;
	private String name;
	private String image;
	private MovieEntity movie;
	private Long movieId;
}
