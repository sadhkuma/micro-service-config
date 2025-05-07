package com.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  hotelId;
    private String name;
    private String location;
    private String about;
}
