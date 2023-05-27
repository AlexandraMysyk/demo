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
    public List<String> getTextsDao() {
        return textDao.findAllTexts();
    }
    @Transactional
    public Text save(Text text) {
        System.out.println("text in save 1"+ text);
        return textDao.save(text);
    }

    @Transactional
    public void deleteText(Text text) {
        textDao.delete(text);
    }

    @Transactional
    public String updateText(String content, String name, String level, int id) {
        return textDao.updateText(content, name, level, id);
    }


    public List<String> getAllByLevel(String complexityLevel) {
        return textDao.findByLevel(complexityLevel);
    }

    public String getTextsByName(String name) {
        return textDao.findByName(name);
    }

    public void deleteTextById(int id) {
         textDao.deleteById(id);
    }
}
