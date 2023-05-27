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

    @PostMapping(path = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody  User user) {
        return new ResponseEntity<>(userService.insertUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/editUser")
    public ResponseEntity<User> editUser(@RequestBody User userNew, @RequestBody  int id) {
        return new ResponseEntity<>(userService.editUser(userNew, id), HttpStatus.CREATED);
    }
    @GetMapping("/checkUserIfExists/{email}")
    public ResponseEntity<User> checkUserIfExists(@RequestBody String email){
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }
}
