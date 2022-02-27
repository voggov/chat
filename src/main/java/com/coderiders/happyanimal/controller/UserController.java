package com.coderiders.happyanimal.controller;

import com.coderiders.happyanimal.model.User;
import com.coderiders.happyanimal.enums.UserRole;
import com.coderiders.happyanimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "hello";
    }

    @PostMapping(path = "/add")
    public String addUser(/*@RequestBody User user*/) {
        User user = new User();
        user.setName("Test Admin");
        user.setUserRole(UserRole.ADMIN);
        user.setAge(19);
        user.setLogin("testLogin");
        user.setPassword("testPassword");

        userService.saveUser(user);
        return "added";
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(path = "/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }
}