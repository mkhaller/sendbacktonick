package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Movie;
import com.services.MovieService;

@CrossOrigin
@Controller
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Object> getAll() {
		return new ResponseEntity<Object>(movieService.getAll(), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable int id) {
		return new ResponseEntity<Object>(movieService.getById(id), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody Movie movie) {
		return new ResponseEntity<Object>(movieService.create(movie), HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable int id) {
		return new ResponseEntity<Object>(movieService.delete(id), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@PathVariable int id, 
			@RequestBody Movie movie) {
		return new ResponseEntity<Object>(movieService.update(id, movie), HttpStatus.OK);
	}
	
}
