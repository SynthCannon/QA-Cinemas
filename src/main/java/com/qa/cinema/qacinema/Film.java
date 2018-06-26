package com.qa.cinema.qacinema;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Film {

	@Id
	@GeneratedValue
	private Long id;
	private @NonNull String title;
	private @NonNull String genre;
	private @NonNull String classification;
	

	public Film(String title, String genre, String classification) {
		this.title = title;
		this.genre = genre;
		this.classification = classification;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public Long getId() {
		return id;
	}

}
