package com.example.demo.controller;

import com.example.demo.entities.KindOfTask;
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

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/getTasksByLevel/{level}/{idUser}")
    public ResponseEntity<List<String>> getTasksByLevel(@RequestBody @PathVariable String level, @RequestBody @PathVariable int idUser) {
        return new ResponseEntity<>(taskService.getAllByLevel(level,idUser), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/getTasksByKind/{kind}/{idUser}")
    public ResponseEntity<List<String>> getTasksByKind(@PathVariable String kind, @PathVariable int idUser) {
        return new ResponseEntity<>(taskService.getAllByKind(kind,idUser), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/getTasksForUser/{idUser}")
    public ResponseEntity<List<String>> getTasksForUser( @PathVariable int idUser) {
        return new ResponseEntity<>(taskService.getAllByUser(idUser), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path = "/addTask")
    public ResponseEntity<Integer> addTask(@RequestBody Task task) {
        taskService.save(task);
        return new ResponseEntity<>(taskService.insertTask(task.getId_user(), task.getId_task()), HttpStatus.CREATED);
    }

}
