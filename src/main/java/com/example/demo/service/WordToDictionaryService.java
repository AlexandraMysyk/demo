package com.example.demo.service;

import com.example.demo.Repositories.WordToDictionaryDao;
import com.example.demo.entities.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordToDictionaryService {
    private final WordToDictionaryDao wordToDictionaryDao;
    @Autowired
    public WordToDictionaryService(WordToDictionaryDao wordToDictionaryDao) {
        this.wordToDictionaryDao = wordToDictionaryDao;
    }
    public void insertByUserId(Word word, int userId, int wordToDictId ){
        wordToDictionaryDao.insertByUserId(wordToDictId,userId,word.getMeaning(),word.getName(),word.getPicture(),word.getTranslation(),word.getContent());
    }
}
