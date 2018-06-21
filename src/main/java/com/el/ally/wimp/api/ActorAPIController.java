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
import com.el.ally.wimp.repositories.ActorRepository;

@RestController
@RequestMapping("/api/actor")
public class ActorAPIController {
	
	private ActorRepository actorRepo;
	
	public ActorAPIController(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
	}
	
	@GetMapping("")
	public List<Actor> getAll(){
		return actorRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Actor getOne(@PathVariable int id) {
		return actorRepo.findOne(id);
	}
	
	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}
	
	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable int id) {
		actor.setId(id);
		return actorRepo.save(actor);
	}
	
	@DeleteMapping("{id}")
	  public Actor delete(@PathVariable int id) {
	    Actor actor = actorRepo.findOne(id);
	    actorRepo.delete(id);
	    return actor;
	  }
	
}
