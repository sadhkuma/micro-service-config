package com.ratinig.entity;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rating {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  ratingId;
    private Long userId;
    private Long hotelId;
    private int rating;
    private String feedback;
}
