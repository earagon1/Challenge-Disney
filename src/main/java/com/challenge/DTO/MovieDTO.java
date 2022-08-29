package com.challenge.DTO;

import java.time.LocalDate;

import com.challenge.Entity.GenreEntity;
import com.challenge.Entity.Qualification;

import lombok.Data;

@Data
public class MovieDTO {
	
	private Long id;		
	private String image;	
	private String title;	
	private LocalDate creation;
	private Qualification qualification;
	private GenreEntity genre;
    private Long genreId;
}
