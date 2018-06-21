package com.el.ally.wimp.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movie")
public class MovieAPIController {
	
	private MovieRepository movieRepo;
	
	
	public MovieAPIController(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}
	
	@GetMapping("")
	public List<Movie> getAll(){
		return movieRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Movie getOne(@PathVariable int id) {
		return movieRepo.findOne(id);
	}
	
	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}
	
	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable int id) {
		movie.setId(id);
		return movieRepo.save(movie);
	}
	
	@DeleteMapping("{id}")
	  public Movie delete(@PathVariable int id) {
	    Movie movie = movieRepo.findOne(id);
	    movieRepo.delete(id);
	    return movie;
	  }
}

