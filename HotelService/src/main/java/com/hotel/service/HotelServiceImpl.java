package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {

		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {

		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(Long hotelId) {

		return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException(
				"User with given id is not found on server: " + hotelId));

	}

}
