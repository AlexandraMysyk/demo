package com.example.demo.controller;

import com.example.demo.entities.TaskToUser;
import com.example.demo.service.TaskToUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskToUserController {
    private final TaskToUserService taskToUserService;
    @Autowired

    public TaskToUserController(TaskToUserService taskToUserService) {
        this.taskToUserService = taskToUserService;
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path = "/addTaskResults/", produces = "taskres/json")
    public ResponseEntity<TaskToUser> addTaskResults(@RequestBody TaskToUser taskToUser) {
        return new ResponseEntity<>(taskToUserService.insertTaskAnswers(taskToUser), HttpStatus.CREATED);
    }

}
