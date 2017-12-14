package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.entities.Movie;

@Repository("MovieDao")
public class MovieDao {
	
	public Movie get(int id, EntityManager em) {
		return em.find(Movie.class, id);
	}
	
	public List<Movie> getAll(EntityManager em) {
		return null;
	}
	
	public Movie delete(int id, EntityManager em) {
		return null;
	}
	
	public Movie create(Movie movie, EntityManager em) {
		em.persist(movie);
		return movie;
	}
	
	public Movie update(int id, Movie movie, EntityManager em) {
		return null;
	}

}
