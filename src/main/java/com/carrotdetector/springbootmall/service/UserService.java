package com.carrotdetector.springbootmall.service;

import com.carrotdetector.springbootmall.dto.UserLoginRequest;
import com.carrotdetector.springbootmall.dto.UserRegisterRequest;
import com.carrotdetector.springbootmall.model.User;

public interface UserService {
    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);

}
