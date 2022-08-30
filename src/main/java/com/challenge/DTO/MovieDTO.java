package com.challenge.DTO;

import java.time.LocalDate;

import com.challenge.Entity.GenreEntity;
import com.challenge.Entity.Qualification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
		
	private String image;	
	private String title;	
	private LocalDate creation;
	private Qualification qualification;
	private GenreEntity genre;
    private Long genreId;
}
