package com.userService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_user")
public class User {

    @Id
    private String id;
    @Column(name = "user_name",length = 50)
    private String name;
    @Column(name = "user-email",length = 50)
    private String email;
    @Column(name = "user-about",length = 500)
    private String about;

    @Transient
    private List<Rating> rating = new ArrayList<>();


}
