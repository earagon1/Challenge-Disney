package com.challenge.Repository.Entity;


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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql="UPDATE character SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "character")
public class CharacterEntity {
	
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

	@Column(name = "character_deleted")
	private boolean characterDeleted = Boolean.FALSE;

}
