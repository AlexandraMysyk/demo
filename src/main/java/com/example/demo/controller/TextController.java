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
@CrossOrigin(origins = "http://localhost:63342")
public class TextController {
    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/getTexts")
    public ResponseEntity<List<String>> getTextsById() {
        return new ResponseEntity<>(textService.getTextsDao(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/getText/{id}")
    public ResponseEntity<String> getTextById(@PathVariable int id) {
        return new ResponseEntity<>(textService.getTextDao(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/getTextsByLevel/{level}")
    public ResponseEntity<List<String>> getTextsByLevel(@PathVariable String level) {
        return new ResponseEntity<>(textService.getAllByLevel(level), HttpStatus.OK);
    }

    @GetMapping(path = "/getTextsByName/{name}")
    public ResponseEntity<String> getTextsByName(@PathVariable String name) {
        return new ResponseEntity<>(textService.getTextsByName(name), HttpStatus.OK);
    }

    @PostMapping("/addText")
    public ResponseEntity<Text> addText(@RequestBody Text text) {
        return new ResponseEntity<>(textService.save(text), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path = "/editText")
    public ResponseEntity<Text> editText(@RequestBody Text text) {
        System.out.println(text.toString());
        try {
            textService.updateText(text);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path = "/deleteText")
    public ResponseEntity<Object> deleteText(@RequestBody int id) {
        try {
            textService.deleteTextById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
