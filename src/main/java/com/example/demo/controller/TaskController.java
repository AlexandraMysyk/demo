package com.example.demo.controller;

import com.example.demo.entities.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path="/getTasksByLevel/{level}", produces = "taskbylevel/json")
    public ResponseEntity<List<Task>> getTasksByLevel(@PathVariable String level) {
        return new ResponseEntity<>(taskService.getAllByLevel(level), HttpStatus.OK);
    }
    @PostMapping(path = "/addTask/", produces = "newtask/json")
    public ResponseEntity<Task> addTask(@RequestBody @PathVariable Task task) {
        return new ResponseEntity<>(taskService.insertTask(task), HttpStatus.CREATED);
    }
}
