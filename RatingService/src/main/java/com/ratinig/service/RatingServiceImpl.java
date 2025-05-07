package com.ratinig.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratinig.entity.Rating;
import com.ratinig.repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(Long userId) {
        try {
            return ratingRepo.findByUserId(userId);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching ratings for user ID: " + userId, e);
        }
    }

    @Override
    public List<Rating> getRatingByHotelId(Long hotelId) {
        try {
            return ratingRepo.findByHotelId(hotelId);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching ratings for hotel ID: " + hotelId, e);
        }
    }
}
