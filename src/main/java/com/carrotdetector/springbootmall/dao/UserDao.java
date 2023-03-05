package com.carrotdetector.springbootmall.dao;

import com.carrotdetector.springbootmall.dto.UserRegisterRequest;
import com.carrotdetector.springbootmall.model.User;

public interface UserDao {
    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);

}
