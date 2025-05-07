package com.ratinig.service;

import java.util.List;

import com.ratinig.entity.Rating;

public interface RatingService {

	//create
	Rating create(Rating rating);
	
	//get all  rating
	List<Rating> getRatings();
	
	
	//get all by userId
	List<Rating> getRatingByUserId(Long userId);
	
	//get all by hotelId
	List<Rating> getRatingByHotelId(Long hotelId);
	
}
