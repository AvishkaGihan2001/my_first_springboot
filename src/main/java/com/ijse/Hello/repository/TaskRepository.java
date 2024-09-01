package com.ijse.Hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.Hello.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
