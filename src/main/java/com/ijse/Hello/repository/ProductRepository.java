package com.ijse.Hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.Hello.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
