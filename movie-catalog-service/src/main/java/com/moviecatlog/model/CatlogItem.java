package com.moviecatlog.model;

public class CatlogItem {

	private Movie movie;
	private int rating;
	
	public CatlogItem(Movie movie, int rating) {
		super();
		this.movie = movie;
		this.rating = rating;
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
