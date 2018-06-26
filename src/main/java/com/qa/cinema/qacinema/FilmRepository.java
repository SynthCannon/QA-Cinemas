package com.qa.cinema.qacinema;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
//@CrossOrigin(origins = "http://localhost:4200")
public interface FilmRepository extends JpaRepository<Film, Long> {
}