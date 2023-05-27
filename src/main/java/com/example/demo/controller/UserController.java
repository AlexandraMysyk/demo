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
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody  User user) {
        return new ResponseEntity<>(userService.insertUser(user), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/editUser")
    public ResponseEntity<User> editUser(@RequestBody User userNew, @RequestBody  int id) {
        return new ResponseEntity<>(userService.editUser(userNew, id), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/checkUserIfExists/{email}/{password}")
    public ResponseEntity<String> checkUserIfExists(@RequestBody @PathVariable String email,@RequestBody @PathVariable  String password){
        return new ResponseEntity<>(userService.getUserByEmail(email, password),HttpStatus.OK);
    }
}
