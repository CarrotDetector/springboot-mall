package com.carrotdetector.springbootmall.service;

import com.carrotdetector.springbootmall.dto.UserRegisisterRequest;
import com.carrotdetector.springbootmall.model.User;

public interface UserService {
    User getUserById(Integer userId);

    Integer register(UserRegisisterRequest userRegisisterRequest);

}
