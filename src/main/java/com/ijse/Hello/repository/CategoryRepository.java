package com.ijse.Hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.Hello.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
