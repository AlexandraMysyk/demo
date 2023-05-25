package com.example.demo.controller;


import com.example.demo.entities.Text;
import com.example.demo.service.TextService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.rmi.ServerException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TextController {
    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping(path = "/getText/{id}")
    public ResponseEntity<String> getTextById(@PathVariable int id) {
        return new ResponseEntity<>(textService.getTextDao(id), HttpStatus.OK);
    }

    @GetMapping(path = "/getTextsByLevel/{level}")
    public ResponseEntity<List<String>> getTextsByLevel(@PathVariable String level) {
        return new ResponseEntity<>(textService.getAllByLevel(level), HttpStatus.OK);
    }
    @GetMapping(path = "/getTextsByName/{name}")
    public ResponseEntity<String> getTextsByName(@PathVariable String name) {
        return new ResponseEntity<>(textService.getTextsByName(name), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://127.0.0.1:8887")
    @PostMapping( "/addText")
    public ResponseEntity<Text> addText(@RequestBody Text text) {
        return new ResponseEntity<>(textService.save(text), HttpStatus.OK);
    }
//

    @PutMapping(path = "/editText")
    public ResponseEntity<String> editText(@RequestBody Text text, @RequestBody String content) {
        return new ResponseEntity<>(textService.updateText(text, content), HttpStatus.OK);
    }
}
