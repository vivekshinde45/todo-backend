package com.service.user.controller;

import com.service.user.model.Task;
import com.service.user.service.implemetations.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService _taskService;

    // CRUD
    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task){
        Task savedTask = _taskService.create(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        List<Task> tasks = _taskService.getAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{taskID}")
    public ResponseEntity<Task> update(@PathVariable String taskID, @RequestBody Task task){
        Task updatedTask = _taskService.update(taskID, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @GetMapping("/{taskID}")
    public ResponseEntity<Task> getByID(@PathVariable String taskID){
        Task task = _taskService.getByID(taskID);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{taskID}")
    public ResponseEntity<String> delete(@PathVariable String taskID){
        try{
            _taskService.delete(taskID);
            return new ResponseEntity<>("Task delete successfully", HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
    }
}
