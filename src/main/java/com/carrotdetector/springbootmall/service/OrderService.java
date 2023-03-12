package com.carrotdetector.springbootmall.service;

import com.carrotdetector.springbootmall.dto.CreateOrderRequest;
import com.carrotdetector.springbootmall.dto.OrderQueryParams;
import com.carrotdetector.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
