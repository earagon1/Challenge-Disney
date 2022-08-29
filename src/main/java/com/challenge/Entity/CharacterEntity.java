package com.challenge.Entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "character")
public class CharacterEntity {
	
	/*
	 * Atributos:
	 * Imagen, Nombre, Edad, Peso, Historia, Películas, series asociadas
	 * 
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="character_id", unique=true, nullable=false)
	private Long characterId;
	
	@Column(name = "character_name")
	private String characterName;

	@Column(name = "character_history")
	private String characterHistory;
	
	@Column(name = "character_weigth")
	private Double characterWeigth;
	
	@Column(name = "character_age")
	private Integer characterAge;
	
	@Column(name = "character_image")
	private String characterImage;

	@ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
	private List<MovieEntity> movies = new ArrayList<>();

}
