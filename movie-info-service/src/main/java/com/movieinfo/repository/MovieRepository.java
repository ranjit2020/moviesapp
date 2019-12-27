package com.movieinfo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.movieinfo.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, Integer> {

	public List<Movie> findByCategory(String category);
}
