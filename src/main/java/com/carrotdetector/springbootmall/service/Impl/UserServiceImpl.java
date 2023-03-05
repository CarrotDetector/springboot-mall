package com.carrotdetector.springbootmall.service.Impl;

import com.carrotdetector.springbootmall.dao.UserDao;
import com.carrotdetector.springbootmall.dto.UserLoginRequest;
import com.carrotdetector.springbootmall.dto.UserRegisisterRequest;
import com.carrotdetector.springbootmall.model.User;
import com.carrotdetector.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisisterRequest userRegisisterRequest) {

        // 檢查註冊的email
        User user = userDao.getUserByEmail(userRegisisterRequest.getEmail());

        if (user != null) {
            log.warn("該 email {} 已經被註冊", userRegisisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 使用MD5生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisisterRequest.getPassword().getBytes());
        userRegisisterRequest.setPassword(hashedPassword);

        // 創建帳號
        return userDao.createUser(userRegisisterRequest);

    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        // 檢查user是否存在
        if (user == null) {
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 使用MD5生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        // 比較密碼
        if (user.getPassword().equals(hashedPassword)) {
            return user;
        } else {
            log.warn("email {} 的密碼不正確", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}