package com.ijse.Hello.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ijse.Hello.entity.Task;

@Service
public interface TaskService {
    Task createTask(Task task);

    List<Task> selectAllTask();

    Task selectByID(Long ID);

    Task updateTask(Long ID, Task task);
    
    void deleteTask(Long ID);
}
