package com.challenge.DTO;

import java.time.LocalDate;
import java.util.List;

import com.challenge.Entity.GenreEntity;
import com.challenge.Entity.Qualification;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDTO {

	private String id;
	private String image;	
	private String title;	
	private LocalDate creation;
	private Qualification qualification;
	private GenreEntity genre;
    private Long genreId;
	private List<Character> characters;

}
