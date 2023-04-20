package com.userService.service.impl;

import com.userService.entity.Rating;
import com.userService.entity.User;
import com.userService.exception.ResourceNotFoundException;
import com.userService.repository.userRepository;
import com.userService.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class userServiceImpl implements userService {

     @Autowired
     private userRepository userRepository;
     @Autowired
     private RestTemplate restTemplate;
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
      ArrayList<Rating> listOfObject =  restTemplate.getForObject("http://localhost:7777/ratings/user/"+user.getId(), ArrayList.class);
        log.info("list of object {}",listOfObject);
        user.setRating(listOfObject);
        return  userRepository.save(user);
    }
}
