package com.example.tasksapp.controller;

import com.example.tasksapp.model.Task;
import com.example.tasksapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    private List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    @GetMapping ("/{taskid}/")
    private Task getTaskById(@PathVariable("taskid") int taskid)
    {

        return taskService.getTaskById(taskid);
    }
    @GetMapping("/{projectId}/tasks")
    public List<Task> getTaskByProjectId(@PathVariable int projectId){
        return taskService.getTaskByProjectId(projectId);
    }

    @PostMapping("/")
    private int saveTask(@RequestBody Task task)
    {
        taskService.saveOrUpdate(task);
        return task.getTaskId();
    }

    @DeleteMapping("/{taskid}")
    private void deleteTask(@PathVariable("taskid") int taskid)
    {
        taskService.delete(taskid);
    }

    @DeleteMapping("{projectId}/tasks")
    private void deleteTasks(@PathVariable int projectId){
        taskService.deleteTasksByProjectId(projectId);
    }

    @PutMapping("/")
    private Task update(@RequestBody Task task)
    {
        taskService.saveOrUpdate(task);
        return task;
    }

}
