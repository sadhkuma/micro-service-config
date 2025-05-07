package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {
	// create
	Hotel createHotel(Hotel hotel);

	// get All Hotel
	List<Hotel> getAll();

	// get single user of given hotelId
	Hotel get(Long hotelId);
}
