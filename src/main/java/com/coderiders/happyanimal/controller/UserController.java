package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.*;
import com.coderiders.happyanimal.service.AnimalService;
import com.coderiders.happyanimal.service.ReportService;
import com.coderiders.happyanimal.service.TaskService;
import com.coderiders.happyanimal.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRsDto addUser(@RequestBody UserRqDto userForm) {
        return userService.saveUser(userForm);
    }

    @GetMapping(path = "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserRsDto> getAllUsers() {
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