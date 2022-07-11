package com.learning.firstapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public List<TaskModel> getAllTasks() {
         var list = taskRepository.getAll();

         return list;
    }

    @GetMapping("/{id}")
    public TaskModel findTaskById(@PathVariable(value = "id") UUID id) {
        var foundTask = taskRepository.findById(id);
        return foundTask;
    }

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task) {
        var createdTask = taskRepository.save(task);
        return createdTask;
    }

    @PutMapping("/{id}")
    public TaskModel updateTask(
            @PathVariable(name = "id") UUID id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description) {
        TaskModel updatedTask = taskRepository.update(id, name, description);
        return updatedTask;
    }


    @DeleteMapping("/{id}")
    public String DeleteTask(@PathVariable(value = "id") UUID id) {
        String taskName = taskRepository.delete(id);
        String deleteMessage = "Task: " + taskName + " foi apagada com sucesso";
        return  deleteMessage;
    }

    @PatchMapping("/{id}/status")
    public TaskModel updateTaskStatus(@PathVariable(value = "id") UUID id) {
        TaskModel updatedTaskStatus = taskRepository.updateStatus(id);
        return  updatedTaskStatus;
    }

}
