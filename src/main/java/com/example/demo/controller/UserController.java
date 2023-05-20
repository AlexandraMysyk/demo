package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/addUser/{user}")
    public ResponseEntity<User> addUser(@RequestBody @PathVariable User user) {
        return new ResponseEntity<>(userService.insertUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/editUser/{user}")
    public ResponseEntity<User> editUser(@RequestBody @PathVariable User userNew, @RequestBody @PathVariable int id) {
        return new ResponseEntity<>(userService.editUser(userNew, id), HttpStatus.CREATED);
    }
}
