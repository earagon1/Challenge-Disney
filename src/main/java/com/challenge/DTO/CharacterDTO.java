package com.challenge.DTO;

import com.challenge.Entity.MovieEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

	private String name;
	private String history;
	private Double weigth;
	private Integer age;
	private String image;
	private MovieEntity movie;
}
