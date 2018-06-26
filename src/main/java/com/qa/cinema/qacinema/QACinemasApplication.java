package com.qa.cinema.qacinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QACinemasApplication implements CommandLineRunner {
	@Autowired
	private FilmRepository filmRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(QACinemasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		filmRepository.save(new Film("a title", "a genre", "a classification"));
		
	}
}
