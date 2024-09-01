package com.ijse.Hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.Hello.entity.Category;

@Service
public interface CategoryService {
    Category createCategory(Category category);

    List<Category> getAll();

    Category selectByID(Long ID);
}
