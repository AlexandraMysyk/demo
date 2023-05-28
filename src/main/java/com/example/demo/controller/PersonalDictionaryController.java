package com.example.demo.controller;

import com.example.demo.entities.PersonalDictionary;
import com.example.demo.entities.Word;
import com.example.demo.service.PersonalDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonalDictionaryController {
private final PersonalDictionaryService personalDictionaryService;
@Autowired

    public PersonalDictionaryController(PersonalDictionaryService personalDictionaryService) {
        this.personalDictionaryService = personalDictionaryService;
    }

}
