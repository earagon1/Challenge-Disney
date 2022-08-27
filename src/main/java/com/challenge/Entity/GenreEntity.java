package com.challenge.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "genre")
public class GenreEntity {

	/*
	 * Nombre,Imagen,Películas o series asociadas
	 * 
	 * */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column (name="genre_id")
	private Long genreId;
	
	@Column (name="genre_name")
	private String genreName;
	
	@Column (name="genre_image")
	private String genreImage;


}