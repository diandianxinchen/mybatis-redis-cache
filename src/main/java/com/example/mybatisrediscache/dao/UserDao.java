package com.example.mybatisrediscache.dao;

import com.example.mybatisrediscache.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    void insertUser(User user);
    List<User> findAll();
}
