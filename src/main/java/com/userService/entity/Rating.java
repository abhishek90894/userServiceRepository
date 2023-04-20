package com.userService.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Rating {

    private String rid;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
