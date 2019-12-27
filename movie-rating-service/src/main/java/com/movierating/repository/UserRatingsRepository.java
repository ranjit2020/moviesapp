package com.movierating.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movierating.model.UserRating;

public interface UserRatingsRepository extends MongoRepository<UserRating, String> {

}
