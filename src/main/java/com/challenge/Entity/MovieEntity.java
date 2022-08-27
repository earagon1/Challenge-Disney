package com.challenge.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class MovieEntity {

	/*
	 * Atributos
	 * Imagen,Título,Fecha de creación,Calificación (del 1 al 5),Personajes asociados
	 * 
	 * */
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column (name="movie_id")
	private Long movieId;
		
	@Column (name="movie_image")
	private String movieImage;
	
	@Column (name="movie_title")
	private String movieTitle;
	
	@Column (name= "movie_creation")
	private Date movieCreation;

	@Column @Enumerated(EnumType.STRING)
	private Qualification qualification;
	
	
}
