package com.example.demo.controller;

import com.example.demo.service.PersonalDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
