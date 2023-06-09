package com.example.demo.controller;

import com.example.demo.entities.Text;
import com.example.demo.entities.Word;
import com.example.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WordController {
    private final WordService wordService;

    @Autowired

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/getAllWords/{idUser}")
    public ResponseEntity<List<String>> getAllWords(@RequestBody @PathVariable int idUser){
        return new ResponseEntity<>(wordService.getAllWordsByUserId(idUser), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping( "/addWord")
    public ResponseEntity<Word> addWord(@RequestBody Word word) {
        return new ResponseEntity<>(wordService.save(word), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping( "/updateWord")
    public ResponseEntity<Object> updateWord(@RequestBody Word word){
        wordService.update(word);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
