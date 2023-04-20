package com.userService.Controller;

import com.userService.entity.User;
import com.userService.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
        private userService userService;

    // create
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user)
    {
      User user1 = userService.save(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleById(@PathVariable String userId)
    {
        User user = userService.getById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //all user
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
