package com.example.demo.service;

import com.example.demo.Repositories.WordDao;
import com.example.demo.entities.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {
    private static WordDao wordDao;

    @Autowired
    public WordService(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public Optional<Word> getWordDao(int id) {
        return wordDao.findById(id);
    }

    public void insertWord(Word word) {
        wordDao.save(word);
    }

    public void deleteWord(Word word) {
        wordDao.delete(word);
    }

    public List<Word> getAllWords() {
        return wordDao.findAll();
    }
}
