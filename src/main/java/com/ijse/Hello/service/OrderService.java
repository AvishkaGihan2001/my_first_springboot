package com.ijse.Hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.Hello.entity.Order;

@Service
public interface OrderService {
    
    Order createOrder(Order order);

    List<Order> getAll();
}
