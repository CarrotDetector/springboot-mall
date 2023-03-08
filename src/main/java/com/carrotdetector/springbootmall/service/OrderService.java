package com.carrotdetector.springbootmall.service;

import com.carrotdetector.springbootmall.dto.CreateOrderRequest;
import com.carrotdetector.springbootmall.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
