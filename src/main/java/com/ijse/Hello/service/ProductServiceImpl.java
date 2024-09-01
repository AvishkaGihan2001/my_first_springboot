package com.ijse.Hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.Hello.entity.Product;
import com.ijse.Hello.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> selectAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product selectByID(Long ID) {
        return productRepository.findById(ID).orElse(null);
    }

    @Override
    public Product updateProduct(Long ID, Product product) {
        Product existingProduct = productRepository.findById(ID).orElse(null);

        if (existingProduct == null) {
            return null;
        } else {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());

            return productRepository.save(existingProduct);
        }
    }

    @Override
    public void deleteProduct(Long ID) {
        productRepository.deleteById(ID);
    }

}
