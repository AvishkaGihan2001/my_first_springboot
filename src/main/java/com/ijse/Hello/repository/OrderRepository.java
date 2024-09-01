package com.ijse.Hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.Hello.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
