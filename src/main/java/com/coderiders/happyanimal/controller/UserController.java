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
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    private AnimalService animalService;
    private TaskService taskService;
    private ReportService reportService;

    @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "hello";
    }

    @PostMapping(path = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public void addTask(@RequestBody TaskRqDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @GetMapping(path = "/reports/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDto> getAllReports() {
        return reportService.getAllReportsDTO();
    }

    @GetMapping(path = "/animals/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalDto> getAllAnimals() {
        return animalService.getAll();
    }

    @GetMapping(path = "/{userId}/reports", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDto> getReportsByUserId(@PathVariable Long userId) {
        return reportService.getReportDTOByUserId(userId);
    }

    @GetMapping(path = "/{userId}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<List<TaskRqDto>> getUserTasks(@PathVariable Long userId) {
        return taskService.getByUserId(userId);
    }

    @GetMapping(path = "/{userId}/animals")
    public List<AnimalDto> getUserAnimals(@PathVariable Long userId) {
        return animalService.getAllByUserId(userId);
    }

    @GetMapping(path = "/animal/{animalId}/tasks")
    public List<TaskRsDto> getAnimalTasks(@PathVariable Long animalId) {
        return animalService.getAnimalTasks(animalId);
    }

    @GetMapping(path = "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserRsDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/tasks/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<TaskRqDto> getAllTasks() {
        return taskService.getAll();
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