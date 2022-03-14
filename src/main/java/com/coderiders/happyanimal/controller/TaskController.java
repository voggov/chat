package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void addTask(@Valid @RequestBody TaskRqDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<List<TaskRqDto>> getUserTasks(@PathVariable Long userId) {
        return taskService.getByUserId(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<TaskRqDto> getAllTasks() {
        return taskService.getAll();
    }
}
