package com.userService.repository;

import com.userService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,String> {


}
