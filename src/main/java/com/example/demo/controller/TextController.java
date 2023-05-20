package com.example.demo.controller;


import com.example.demo.entities.Text;
import com.example.demo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TextController {
    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping(path="/getText/{id}",produces = "text/json")
    public ResponseEntity<Text> getTextById(@PathVariable int id) {
        return new ResponseEntity<>(textService.getTextDao(id), HttpStatus.OK);
    }

    @GetMapping(path="/getTextsByLevel/{level}",produces = "textById/json")
    public ResponseEntity<List<Text>> getTextsByLevel(@PathVariable String level) {
        return new ResponseEntity<>(textService.getAllByLevel(level), HttpStatus.OK);
    }

    @PostMapping(path = "/addText",consumes = "text/json")
    public ResponseEntity<Text> addText(@RequestBody  Text text) {
        return new ResponseEntity<>(textService.insertText(text), HttpStatus.CREATED);
    }

    @PostMapping(path="/editText",consumes="text/json")
    public ResponseEntity<Text> editText(@RequestBody Text text, @RequestBody String content) {
        return new ResponseEntity<>(textService.updateText(text, content), HttpStatus.OK);
    }
}
