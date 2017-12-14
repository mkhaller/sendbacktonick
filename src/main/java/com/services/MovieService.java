package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MovieDao;
import com.entities.Movie;

@Service("MovieService")
public class MovieService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default_JPA");
	
	@Autowired
	MovieDao movieDao;
	
	public List<Movie> getAll() {
		return null;
	}
	
	public Movie getById(int id) {
		Movie foundMovie = null;
		EntityManager em = emf.createEntityManager();
		try {
			foundMovie = movieDao.get(id, em);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return foundMovie;
	}
	
	public Movie create(Movie movie) {
		Movie createdMovie = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
			createdMovie = movieDao.create(movie, em);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			em.close();
		}
	
		return createdMovie;
	}
	
	public Movie delete(int id) {
		return null;
	}
	
	public Movie update(int id, Movie movie) {
		return null;
	}
}
