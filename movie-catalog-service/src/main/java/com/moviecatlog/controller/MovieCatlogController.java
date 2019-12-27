package com.moviecatlog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviecatlog.model.CatlogItem;
import com.moviecatlog.model.Movie;
import com.moviecatlog.model.MovieCatlog;
import com.moviecatlog.model.Rating;
import com.moviecatlog.model.UserRating;

@RestController
@RequestMapping("/api")
public class MovieCatlogController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/catlog/{userId}")
	ResponseEntity<MovieCatlog> getMovieCatlog(@PathVariable String userId) {
		
		UserRating userRating = restTemplate.getForObject("http://MOVIE-RATING-SERVICE/api/ratings/"+userId, UserRating.class);
		List<Rating> ratings = userRating.getRatings();
		
		List<CatlogItem> catlogItems = new ArrayList<CatlogItem>();
		
		for(Rating rating : ratings) {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/api/movie/"+rating.getMovieId(), Movie.class);
			catlogItems.add(new CatlogItem(movie, rating.getRating()));
		}
		MovieCatlog movieCatlog =new MovieCatlog(catlogItems);
		
		return new ResponseEntity<MovieCatlog>(movieCatlog,HttpStatus.OK);
	}

}
