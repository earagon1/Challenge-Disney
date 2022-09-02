package com.challenge.Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



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
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate movieCreation;

	@Column (name= "qualification")
	@Enumerated(EnumType.STRING)
	private Qualification qualification;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
	private GenreEntity genre;
	
	@Column(name = "genre_id", nullable = false)
	private Long genreId;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "character_movie", joinColumns = @JoinColumn(name= "movie_id"),inverseJoinColumns = @JoinColumn(name = "character_id"))
	private Set<CharacterEntity> characters = new HashSet<>();












}
