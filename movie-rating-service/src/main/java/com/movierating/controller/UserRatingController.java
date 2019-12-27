package com.movierating.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.model.UserRating;
import com.movierating.repository.UserRatingsRepository;

@RestController
@RequestMapping("/api")
public class UserRatingController {

	@Autowired
	UserRatingsRepository userRatingsRepository;
	
	@RequestMapping("/ratings/{userName}")
	public ResponseEntity<UserRating> getUserRatings(@PathVariable String userName) {
		
		Optional<UserRating> result = userRatingsRepository.findById(userName);
		ResponseEntity<UserRating> response = null;

		if (result.isPresent()) 
			response = new ResponseEntity<UserRating>(result.get(), HttpStatus.OK);
		else
			response = new ResponseEntity<UserRating>(HttpStatus.NOT_FOUND);

		return response;
	}
}
