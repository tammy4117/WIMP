package com.el.ally.wimp.configuration;


import java.sql.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.ActorRepository;
import com.el.ally.wimp.repositories.MovieRepository;

@Configuration
@Profile("development")
public class SeedData {
	
	public SeedData(MovieRepository movieRepository, ActorRepository actorRepository) {
		movieRepository.save(new Movie("Bring it on", null, null, "Paramount"));
		Actor actorTemp = new Actor("Ellen", "Degeneras", 2008L, new Date(23498723498L));
		Actor actorTemp2 = new Actor("Bobb", "sdfs", 2005L, new Date(23498723498L));
		Movie movieTemp = new Movie("Finding Nemo", new Date(232322323232L), 2349859L, "Universal");
		movieRepository.save(movieTemp);
		actorRepository.save(actorTemp);
		actorRepository.save(actorTemp2);
	}

}
