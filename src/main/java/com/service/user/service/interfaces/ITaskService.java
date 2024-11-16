package com.service.user.service.interfaces;

import com.service.user.model.Task;

import java.util.List;

public interface ITaskService {
    // crud
    //create
    Task create(Task task);

    //read
    //by ID
    Task getByID(String taskID);

    //ALL
    List<Task> getAll();

    //update
    Task update(String taskId, Task task);

    //delete
    void delete(String taskId);
}
