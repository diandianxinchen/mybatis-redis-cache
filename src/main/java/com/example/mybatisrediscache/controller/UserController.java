package com.example.mybatisrediscache.controller;

import com.example.mybatisrediscache.entity.User;
import com.example.mybatisrediscache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUser(){
        return userService.findAll();
    }

    @PostMapping
    public void addUser(User user){
        userService.addUser(user);
    }
}
