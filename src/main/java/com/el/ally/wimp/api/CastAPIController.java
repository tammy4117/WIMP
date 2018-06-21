package com.el.ally.wimp.api;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;
@RestController
@RequestMapping("/api/movie/{movieId}/actors")
public class CastAPIController {

	private MovieRepository movieRepo;
	private ActorRepository actorRepo;
	
	public CastAPIController(MovieRepository movieRepo, ActorRepository actorRepository) {
		this.movieRepo = movieRepo;
		this.actorRepo = actorRepository;
	}
	
	@GetMapping
	public List<Actor> getAll(@PathVariable int movieId){
		return movieRepo.findOne(movieId).getActors();
	}

	@PostMapping
	public Movie create(@RequestBody int actorId, @PathVariable int movieId) {
		Movie movie = movieRepo.findOne(movieId);
		Actor actor = actorRepo.findOne(actorId);
		movie.getActors().add(actor);
		movieRepo.save(movie);
		return movie;
	}
	
	
}
