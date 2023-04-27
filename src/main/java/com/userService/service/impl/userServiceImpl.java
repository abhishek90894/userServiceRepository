package com.userService.service.impl;

import com.userService.entity.Hotel;
import com.userService.entity.Rating;
import com.userService.entity.User;
import com.userService.exception.ResourceNotFoundException;
import com.userService.external.service.HotelService;
import com.userService.repository.userRepository;
import com.userService.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class userServiceImpl implements userService {

     @Autowired
     private userRepository userRepository;
     @Autowired
     private RestTemplate restTemplate;
     @Autowired
    HotelService hotelService;
    @Override
    public User save(User user) {
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public User getById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());
        // fetch rating of the above user by user service
        //http://localhost:7777/ratings/user/68773b54-51b2-4473-8804-49549525c4d1
      Rating [] listOfObject =  restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getId(), Rating[].class);

        List<Rating> ratings =  Arrays.stream(listOfObject).toList();
        ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //set the hotel to rating
            //return the rating
       //http://localhost:8888/hotel/eafbb7b2-7742-45bc-b27c-ee4a26a7f786
       ResponseEntity<Hotel> forEntity     = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
         Hotel hotel = forEntity.getBody();

           // Hotel hotel = hotelService.getHotel(rating.getHotelId());
            log.error("hotel {}",hotel);
        rating.setHotel(hotel);
        return rating;
        }).collect(Collectors.toList());
      log.info("list of object {}",listOfObject);
        user.setRating(ratings);
        return  user;

    }
}
