package com.carrotdetector.springbootmall.controller;

import com.carrotdetector.springbootmall.dto.UserRegisisterRequest;
import com.carrotdetector.springbootmall.model.User;
import com.carrotdetector.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisisterRequest userRegisisterRequest) {

        Integer userId = userService.register(userRegisisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
