package com.challenge.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql="UPDATE character SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "genre")
public class GenreEntity {

	/*
	 * Atributos
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

	@Column(name = "genre_deleted")
	private boolean genreDeleted = Boolean.FALSE;


}
