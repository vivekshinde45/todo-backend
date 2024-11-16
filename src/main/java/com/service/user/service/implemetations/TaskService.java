package com.service.user.service.implemetations;

import com.service.user.model.Task;
import com.service.user.repository.TaskRepository;
import com.service.user.service.interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository _taskRepository;

    @Override
    public Task create(Task task) {
        Task savedTask = _taskRepository.save(task);
        return savedTask;
    }

    @Override
    public Task getByID(String taskID) {
        Optional<Task> optionalTask = _taskRepository.findById(taskID);
        if(optionalTask.isEmpty()){
            return null;
        }
        else return     optionalTask.get();
    }

    @Override
    public List<Task> getAll() {
        return _taskRepository.findAll();
    }

    @Override
    public Task update(String taskId, Task task) {
        Task getTask = getByID(taskId);
        if(getTask != null){
            getTask.setTaskName(task.getTaskName());
            getTask.setTaskDescription(task.getTaskDescription());
            return _taskRepository.save(getTask);
        }
        return null;
    }

    @Override
    public void delete(String taskId) {
        Task getTask = getByID(taskId);
        if(getTask != null){
            _taskRepository.delete(getTask);
        }
    }
}
