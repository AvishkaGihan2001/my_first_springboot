package com.ijse.Hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.Hello.entity.Task;
import com.ijse.Hello.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody Task task) {

        if (task.getName() == null || task.getName() == "") {
            return ResponseEntity.status(400).body("Please enter a valid name !");
        }

        if (task.getPriority() == null) {
            return ResponseEntity.status(400).body("Please enter a valid number !");
        }

        try {
            Task createdTask = taskService.createTask(task);
            return ResponseEntity.status(201).body(createdTask);

        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> selectAllTask() {
        List<Task> task = taskService.selectAllTask();
        return ResponseEntity.status(200).body(task);
    }

    @GetMapping("/tasks/{taskID}")
    public ResponseEntity<Task> selectByID(@PathVariable Long taskID) {
        Task task = taskService.selectByID(taskID);

        if (task == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(task);
        }
    }

    @PutMapping("tasks/{ID}")
    public ResponseEntity<Task> updateTask(@PathVariable Long ID, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(ID, task);

        if (updatedTask == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(task);
        }

    }

    @DeleteMapping("tasks/{ID}")
    public void deleteTask(@PathVariable Long ID) {
        taskService.deleteTask(ID);
    }

}
