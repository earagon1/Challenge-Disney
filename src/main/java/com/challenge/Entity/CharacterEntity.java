package com.challenge.Entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

	@ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
	private List<MovieEntity> movies = new ArrayList<>();

	
	
	/*Es provisorio hasta arreglar los getter y setters*/
	
	public Long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterHistory() {
		return characterHistory;
	}

	public void setCharacterHistory(String characterHistory) {
		this.characterHistory = characterHistory;
	}

	public Double getCharacterWeigth() {
		return characterWeigth;
	}

	public void setCharacterWeigth(Double characterWeigth) {
		this.characterWeigth = characterWeigth;
	}

	public Integer getCharacterAge() {
		return characterAge;
	}

	public void setCharacterAge(Integer characterAge) {
		this.characterAge = characterAge;
	}

	public String getCharacterImage() {
		return characterImage;
	}

	public void setCharacterImage(String characterImage) {
		this.characterImage = characterImage;
	}

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}


}
