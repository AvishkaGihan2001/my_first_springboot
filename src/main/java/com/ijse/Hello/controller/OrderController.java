package com.ijse.Hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.Hello.dto.OrderDTO;
import com.ijse.Hello.entity.Order;
import com.ijse.Hello.entity.Product;
import com.ijse.Hello.service.OrderService;
import com.ijse.Hello.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDto) {
        List<Long> productIDs = orderDto.getProductIDs();

        Order order = new Order();
        order.setTotalPrice(0.0);
        List<Product> orderedProducts = new ArrayList<>();

        productIDs.forEach(productID -> {
            // Get product ID
            Product product = productService.selectByID(productID);

            if (product != null) {
                orderedProducts.add(product);
                order.setTotalPrice(order.getTotalPrice() + product.getPrice());
            }

        });

        order.setOrderedProducts(orderedProducts);
        orderService.createOrder(order);
        return ResponseEntity.status(201).body(order);

    }

}
