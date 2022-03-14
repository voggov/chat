package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.dto.UserRqDto;
import com.coderiders.happyanimal.model.dto.UserRsDto;
import com.coderiders.happyanimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRsDto addUser(@Valid @RequestBody UserRqDto userForm) {
        return userService.saveUser(userForm);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserRsDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserRsDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }
}