package com.userService;

import com.userService.entity.Hotel;
import com.userService.entity.Rating;
import com.userService.external.service.HotelService;
import com.userService.external.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	private RatingService ratingService;

	@Autowired
	private HotelService hotelService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating()
	{
		Rating rating = Rating.builder()
				.rating(7)
				.feedback("fine hotel")
				.userId("")
				.hotel(null)
				.hotelId("")
				.build();
		Rating rating1 = ratingService.createRating(rating);
		log.info("rating"+rating1);

	}
    @Test
	void createHotel()
	{
		Hotel hotel = Hotel.builder()
				.about("five star hotel")
				.location("kanpur")
				.name("negi")
				.build();

		Hotel hotel1 = hotelService.createHotel(hotel);
		log.info("hotel is create {}",hotel1);

	}



}
