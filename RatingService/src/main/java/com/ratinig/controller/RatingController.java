package com.ratinig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ratinig.entity.Rating;
import com.ratinig.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

//create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}

	// getall
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings() {
		return ResponseEntity.ok(ratingService.getRatings());
	}

	// get all by userId
//	@GetMapping("/user/{userId}")
//	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Long userId){
//		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
//	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}

	// get all by hotelId
//	@GetMapping("/hotel/{hotelId}")
//	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") Long hotelId) {
//		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
//	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") Long hotelId) {
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}

}
