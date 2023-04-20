package com.userService.service;

import com.userService.entity.User;

import java.util.List;

public interface userService {

    // save user
    User save(User user);

    //get all user
    List<User> getAll();

    //get user by id

    User getById(String userId);


}
