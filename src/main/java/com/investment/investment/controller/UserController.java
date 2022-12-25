package com.investment.investment.controller;

import com.investment.investment.entity.UserEntity;
import com.investment.investment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE USER
    @PostMapping("/user")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    // CARI USER {ID}
    @GetMapping("/user/{userId}")
    public UserEntity findById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    // CARI SEMUA USER
    @GetMapping("/user")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    // EDIT USER {ID}
    @PostMapping("/user/{userId}")
    public UserEntity update(@PathVariable Long userId, @RequestBody UserEntity userEntity){
        return userService.update(userId, userEntity);
    }

    @DeleteMapping("/user/{userId}")
    String deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
}
