package com.ijse.Hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.Hello.dto.ProductReqDTO;
import com.ijse.Hello.entity.Category;
import com.ijse.Hello.entity.Product;
import com.ijse.Hello.service.CategoryService;
import com.ijse.Hello.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductReqDTO productReqDTO) {

        try {
            Product newProduct = new Product();
            newProduct.setName(productReqDTO.getName());
            newProduct.setDescription(productReqDTO.getDescription());
            newProduct.setPrice(productReqDTO.getPrice());

            Category category = categoryService.selectByID(productReqDTO.getCategoryID());

            newProduct.setCategory(category);

            Product createdProduct = productService.createProduct(newProduct);
            return ResponseEntity.status(201).body(createdProduct);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> selectAllProduct() {
        List<Product> product = productService.selectAllProduct();
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/product/{productID}")
    public ResponseEntity<Product> selectByID(@PathVariable Long productID) {
        Product product = productService.selectByID(productID);

        if (product == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(product);
        }
    }

    @PutMapping("/product/{productID}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productID, @RequestBody Product product) {
        if (product.getName() == null || product.getName() == "") {
            return ResponseEntity.status(400).body("Please enter a valid name !");
        }

        if (product.getPrice() == null) {
            return ResponseEntity.status(400).body("Please enter a valid number !");
        }

        try {
            Product updatedProduct = productService.updateProduct(productID, product);
            return ResponseEntity.status(200).body(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/product/{productID}")
    public void deleteProduct(@PathVariable Long productID) {
        productService.deleteProduct(productID);
    }

}
