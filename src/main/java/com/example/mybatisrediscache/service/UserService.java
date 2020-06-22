package com.example.mybatisrediscache.service;

import com.example.mybatisrediscache.dao.UserDao;
import com.example.mybatisrediscache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.insertUser(user);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
