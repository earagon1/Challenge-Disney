package com.challenge.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql="UPDATE character SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "movie")
public class MovieEntity {

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

	@Column(name = "movie_deleted")
	private boolean movieDeleted = Boolean.FALSE;

}
