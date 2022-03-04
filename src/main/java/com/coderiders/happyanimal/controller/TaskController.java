package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/tasks/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody TaskRqDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @GetMapping(path = "/{userId}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<List<TaskRqDto>> getUserTasks(@PathVariable Long userId) {
        return taskService.getByUserId(userId);
    }

    @GetMapping(path = "/tasks/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<TaskRqDto> getAllTasks() {
        return taskService.getAll();
    }
}
