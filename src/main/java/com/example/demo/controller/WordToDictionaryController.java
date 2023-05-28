package com.example.demo.controller;

import com.example.demo.entities.Word;
import com.example.demo.entities.WordToDictionary;
import com.example.demo.service.WordToDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WordToDictionaryController {
    private final WordToDictionaryService wordToDictionaryService;
    @Autowired
    public WordToDictionaryController(WordToDictionaryService wordToDictionaryService) {
        this.wordToDictionaryService = wordToDictionaryService;
    }
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping( "/addWordToDictionary/{userId}/{wordToDictId}")
    public ResponseEntity<WordToDictionary> addWordToDictionary(@RequestBody Word word, @RequestBody @PathVariable int userId, @RequestBody @PathVariable int wordToDictId) {
        wordToDictionaryService.insertByUserId(word,userId, wordToDictId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
