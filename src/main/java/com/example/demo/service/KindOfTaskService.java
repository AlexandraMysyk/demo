package com.example.demo.service;

import com.example.demo.Repositories.KindOfTaskDao;
import com.example.demo.entities.KindOfTask;
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

    public void insertKindOfTask(KindOfTask kindOfTask) {
        kindOfTaskDao.save(kindOfTask);
    }

    public void deleteKindOfTask(KindOfTask kindOfTask) {
        kindOfTaskDao.delete(kindOfTask);
    }

    public List<KindOfTask> getAllTasks() {
        return kindOfTaskDao.findAll();
    }
}
