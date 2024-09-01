package com.ijse.Hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.Hello.entity.Task;
import com.ijse.Hello.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> selectAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task selectByID(Long ID) {
        return taskRepository.findById(ID).orElse(null);
    }

    @Override
    public Task updateTask(Long ID, Task task) {
        Task existingTask = taskRepository.findById(ID).orElse(null);

        if (existingTask == null) {
            return null;
        } else {
            existingTask.setName(task.getName());
            existingTask.setPriority(task.getPriority());
            existingTask.setDueDate(task.getDueDate());

           return taskRepository.save(existingTask);
        }
    }

    @Override
    public void deleteTask(Long ID) {
         taskRepository.deleteById(ID);
    }



}
