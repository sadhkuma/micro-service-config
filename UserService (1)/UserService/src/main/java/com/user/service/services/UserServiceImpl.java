package com.user.service.services;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.services.HotelServiceClient;
import com.user.service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private HotelServiceClient hotelServiceClient;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
     public User getUser(Long userId) {
         User user = userRepo.findById(userId).orElseThrow(
                 () -> new ResourceNotFoundException("User with given id is not found on server: " + userId));

         // Fetch ratings of the user
         String url = "http://RATINGSERVICE/ratings/user/" + userId;
         Rating[] ratings = restTemplate.getForObject(url, Rating[].class);

         // Fetch hotel details for each rating using FeignClient
         for (Rating rating : ratings) {
        	 
        	// Convert String to Long if necessary
        	 Long hotelId = Long.parseLong(rating.getHotelId()); 
        	 
             Hotel hotel = hotelServiceClient.getHotel(hotelId);
             rating.setHotel(hotel);
         }

         // Set ratings to the user
         user.setRatings(Arrays.asList(ratings));

         return user;
	}
}