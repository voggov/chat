package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.TaskRqDto;
import com.coderiders.happyanimal.model.dto.TaskRsDto;
import com.coderiders.happyanimal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskRsDto> addTask(@Validated @RequestBody TaskRqDto taskDto) {
        var created = taskService.saveTask(taskDto);
        var url = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(url).body(created);
    }


    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TaskRsDto> getUserTasks(@PathVariable Long userId, Pageable pageable) {
        return taskService.getByUserId(userId, pageable);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TaskRsDto> getAllTasks(Pageable pageable) {
        return taskService.getAll(pageable);
    }
}
