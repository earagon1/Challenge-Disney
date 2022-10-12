package com.challenge.DTO;

import com.challenge.Entity.MovieEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

	private Long id;
	private String name;
	private String story;
	private Double weigth;
	private Integer age;
	private String image;
	private List<MovieDTO> movies;
	
}
