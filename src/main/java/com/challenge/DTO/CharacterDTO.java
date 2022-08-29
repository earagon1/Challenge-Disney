package com.challenge.DTO;

import com.challenge.Entity.MovieEntity;

import lombok.Data;

@Data
public class CharacterDTO {

	private Long id;
	private String name;
	private String history;
	private Double weigth;
	private Integer age;
	private String image;
	private MovieEntity movie;
}
