package com.qa.cinema.qacinema;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class FilmController {

	private FilmRepository filmRepository;
	
	public FilmController(FilmRepository filmRepository) {
    	this.filmRepository = filmRepository;
    }
	
	
	@GetMapping("/films")
	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}
	
	@GetMapping("/films/{id}")
	public String getFilmById(@PathVariable long id) {
		return new Gson().toJson(filmRepository.findById(id));
	}
	
	@PostMapping("/films/add")
	public String addFilm(@RequestBody String film) {
		filmRepository.save(new Gson().fromJson(film, Film.class));
		return "\"message\" : \"Film added\"";
	}
	
	@PutMapping("/films/edit")
	public String editFilm(@RequestBody String film) {
		Film newFilm = new Gson().fromJson(film, Film.class);
		Film oldFilm = filmRepository.findById(newFilm.getId()).get();
		oldFilm.setTitle(newFilm.getTitle());
		oldFilm.setGenre(newFilm.getGenre());
		oldFilm.setClassification(newFilm.getClassification());
		filmRepository.save(oldFilm);
		return "\"message\" : \"Film edited\"";
	}
	
	@DeleteMapping("films/remove/{id}")
	public String removeFilm(@PathVariable long id) {
		filmRepository.deleteById(id);
		return "\"message\" : \"Film deleted\"";		
	}
	
}
