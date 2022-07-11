package com.learning.firstapi;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TaskRepository {
    List<TaskModel> tasks = new ArrayList<>();

    public TaskModel save (TaskModel task) {
        TaskModel newTask = new TaskModel();
        newTask.setId();
        newTask.setName(task.getName());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(TaskStatus.created);

        tasks.add(newTask);
        return newTask;
    }

    public List<TaskModel> getAll() {
        return tasks;
    }

    public TaskModel findById(UUID id) {
       TaskModel foundTask = tasks.stream().filter(task -> task.getId().equals(id)).findFirst().get();
       return foundTask;
    }

    public TaskModel update(UUID id, String name, String description) {
        TaskModel foundTask = tasks.stream().filter(task -> task.getId().equals(id)).findFirst().get();
        var taskIndex = tasks.indexOf(foundTask);
        foundTask.setName(name);
        foundTask.setDescription(description);
        tasks.set(taskIndex, foundTask);

        return foundTask;
    }

    public TaskModel updateStatus(UUID id) {
        TaskModel foundTask = tasks.stream().filter(task -> task.getId().equals(id)).findFirst().get();
        var taskIndex = tasks.indexOf(foundTask);

        if(foundTask.getStatus() == TaskStatus.created) {
            foundTask.setStatus(TaskStatus.done);
        } else {
            foundTask.setStatus(TaskStatus.created);
        }
        tasks.set(taskIndex, foundTask);

        return foundTask;
    }

    public String delete(UUID id) {
        TaskModel foundTask = tasks.stream().filter(task -> task.getId().equals(id)).findFirst().get();

        tasks.remove(foundTask);
        return foundTask.getName();
    }

}
