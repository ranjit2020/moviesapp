package com.movierating.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userratings")
public class UserRating {

	@Id
	private String userId;
	
	private List<Rating> ratings;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	@Override
	public String toString() {
		return "UserRating [userId=" + userId + ", ratings=" + ratings + "]";
	}
}
