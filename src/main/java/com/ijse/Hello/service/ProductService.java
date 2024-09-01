package com.ijse.Hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.Hello.entity.Product;

@Service
public interface ProductService {
    Product createProduct(Product product);

    List<Product> selectAllProduct();

    Product selectByID(Long ID);

    Product updateProduct(Long ID, Product product);

    void deleteProduct(Long ID);
}
