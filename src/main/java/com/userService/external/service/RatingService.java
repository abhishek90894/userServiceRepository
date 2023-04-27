package com.userService.external.service;

import com.userService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService
{

    //post
    @PostMapping("/ratings")
    Rating createRating(Rating rating);





}
