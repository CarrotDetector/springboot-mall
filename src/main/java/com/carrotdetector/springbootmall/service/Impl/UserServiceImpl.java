package com.carrotdetector.springbootmall.service.Impl;

import com.carrotdetector.springbootmall.dao.UserDao;
import com.carrotdetector.springbootmall.dto.UserRegisisterRequest;
import com.carrotdetector.springbootmall.model.User;
import com.carrotdetector.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisisterRequest userRegisisterRequest) {
        return userDao.createUser(userRegisisterRequest);
    }

}
