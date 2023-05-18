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

    @GetMapping("/getText/{id}")
    public ResponseEntity<Text> getTextById(@PathVariable int id) {
        return new ResponseEntity<>(textService.getTextDao(id), HttpStatus.OK);
    }

    @GetMapping("/getTextsByLevel/{level}")
    public ResponseEntity<List<Text>> getTextsByLevel(@PathVariable String level) {
        return new ResponseEntity<>(textService.getAllByLevel(level), HttpStatus.OK);
    }

    @PostMapping("/add/{text}")
    public ResponseEntity<Text> addText(@RequestBody @PathVariable Text text) {
        return new ResponseEntity<>(textService.insertText(text), HttpStatus.CREATED);
    }

    @PostMapping("/edit/{text}")
    public ResponseEntity<Text> editText(@RequestBody @PathVariable Text text, @RequestBody String content) {
        return new ResponseEntity<>(textService.updateText(text, content), HttpStatus.OK);
    }
}
