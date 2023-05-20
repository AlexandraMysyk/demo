package com.example.demo.service;

import com.example.demo.Repositories.KindOfTaskDao;
import com.example.demo.entities.KindOfTask;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindOfTaskService {
    private final KindOfTaskDao kindOfTaskDao;

    @Autowired
    private KindOfTaskService(KindOfTaskDao kindOfTaskDao) {
        this.kindOfTaskDao = kindOfTaskDao;
    }

//    @Transactional
//    public void insertKindOfTask(KindOfTask kindOfTask) {
//        kindOfTaskDao.save(kindOfTask);
//    }
//
//    @Transactional
//    public void deleteKindOfTask(KindOfTask kindOfTask) {
//        kindOfTaskDao.delete(kindOfTask);
//    }
//
//    public List<KindOfTask> getAllTexts() {
//        return kindOfTaskDao.findAll();
//    }
}
