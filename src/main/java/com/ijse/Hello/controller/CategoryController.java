package com.ijse.Hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.Hello.entity.Category;
import com.ijse.Hello.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("category")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        if (category.getName() == null || category.getName() == "") {
            return ResponseEntity.status(400).body("Please enter a valid name !");
        }

        try {
            Category createCategory = categoryService.createCategory(category);
            return ResponseEntity.status(201).body(createCategory);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("categories")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> category = categoryService.getAll();
        return ResponseEntity.status(200).body(category);
    }

    @GetMapping("category/{ID}")
    public ResponseEntity<Category> selectByID(@PathVariable Long ID) {
        Category category = categoryService.selectByID(ID);
        return ResponseEntity.status(200).body(category);
    }

}
