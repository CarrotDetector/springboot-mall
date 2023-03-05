package com.carrotdetector.springbootmall.dao;

import com.carrotdetector.springbootmall.dto.UserRegisisterRequest;
import com.carrotdetector.springbootmall.model.User;

public interface UserDao {
    User getUserById(Integer userId);

    Integer createUser(UserRegisisterRequest userRegisisterRequest);

}
