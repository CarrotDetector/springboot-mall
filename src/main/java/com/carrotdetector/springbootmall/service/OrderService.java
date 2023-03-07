package com.carrotdetector.springbootmall.service;

import com.carrotdetector.springbootmall.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
