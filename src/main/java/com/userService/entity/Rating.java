package com.userService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Slf4j
public class Rating {


    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
