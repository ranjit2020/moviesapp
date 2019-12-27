package com.moviecatlog.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="moviecatlog")
public class MovieCatlog {

	List<CatlogItem> catlogItems;
	
	public List<CatlogItem> getCatlogItems() {
		return catlogItems;
	}

	public MovieCatlog(List<CatlogItem> catlogItems) {
		super();
		this.catlogItems = catlogItems;
	}

	public void setCatlogItems(List<CatlogItem> catlogItems) {
		this.catlogItems = catlogItems;
	}

}
