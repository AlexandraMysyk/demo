package com.example.demo.service;

import com.example.demo.Repositories.PersonalDictionaryDao;
import com.example.demo.entities.PersonalDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDictionaryService {
    private final PersonalDictionaryDao personalDictionaryDao;

    @Autowired
    public PersonalDictionaryService(PersonalDictionaryDao personalDictionaryDao) {
        this.personalDictionaryDao = personalDictionaryDao;
    }

    public void insertPersonalDictionary(PersonalDictionary personalDictionary) {
        personalDictionaryDao.save(personalDictionary);
    }

    public void deletePersonalDictionary(PersonalDictionary personalDictionary) {
        personalDictionaryDao.delete(personalDictionary);
    }

    public List<PersonalDictionary> getAllTexts() {
        return personalDictionaryDao.findAll();
    }
}
