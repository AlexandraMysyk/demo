package com.example.demo.service;

import com.example.demo.Repositories.TextDao;
import com.example.demo.entities.Text;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextService {
    private final TextDao textDao;

    @Autowired
    public TextService(TextDao textDao) {
        this.textDao = textDao;
    }

    public String getTextDao(int id) {
        return textDao.findById(id);
    }

    @Transactional
    public Text insertText(Text text) {
        return textDao.save(text);
    }

    @Transactional
    public void deleteText(Text text) {
        textDao.delete(text);
    }

    @Transactional
    public Text updateText(Text text, String content) {
        return textDao.updateText(text, content);
    }

    public List<Text> getAllTexts() {
        return textDao.findAll();
    }

    public List<Text> getAllByLevel(String complexityLevel) {
        return textDao.findByLevel(complexityLevel);
    }


}
