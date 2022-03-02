package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.*;
import com.coderiders.happyanimal.service.AnimalService;
import com.coderiders.happyanimal.service.ReportService;
import com.coderiders.happyanimal.service.TaskService;
import com.coderiders.happyanimal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private AnimalService animalService;
    private TaskService taskService;
    private ReportService reportService;

    @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "hello";
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRsDto addUser(@RequestBody UserRqDto userForm) {
        return userService.saveUser(userForm);
    }

    @PostMapping(path = "/{userId}/animals/add")
    public AnimalDto addAnimal(@RequestBody AnimalDto animalDto, @PathVariable Long userId) {
        return animalService.saveAnimal(animalDto, userId);
    }

    @PostMapping(path = "/{userId}/reports/add")
    public void addReport(@RequestBody ReportDto reportDto, @PathVariable Long userId) {
        reportService.saveReport(reportDto, userId);
    }

    @PostMapping(path = "/tasks/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody TaskDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @GetMapping(path = "/reports/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDto> getAllReports() {
        return reportService.getAllReportsDTO();
    }

    @GetMapping(path = "/{userId}/reports", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDto> getReportsByUserId(@PathVariable Long userId) {
        return reportService.getReportDTOByUserId(userId);
    }

    @GetMapping(path = "/{userId}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<List<TaskDto>> getUserTasks(@PathVariable Long userId) {
        return taskService.getByUserId(userId);
    }

    @GetMapping(path = "/{userId}/animals")
    public List<AnimalDto> getUserAnimals(@PathVariable Long userId) {
        return animalService.getAllByUserId(userId);
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserRsDto> getAll() {
        return userService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserRsDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(path = "/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserRsDto> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }
}