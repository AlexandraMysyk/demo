package com.example.demo.service;

import com.example.demo.Repositories.TaskDao;
import com.example.demo.entities.Task;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskDao taskDao;

    @Autowired
    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public <idUser> List<String> getAllByLevel(String complexityLevel, int idUser) {
        return taskDao.findByLevel(complexityLevel , idUser);
    }
    public <idUser> List<String> getAllByKind(String kindOfTask, int idUser) {
        return taskDao.findByKind(kindOfTask , idUser);
    }
    public List<String> getAllByUser(int idUser){
        return taskDao.getAllByUser(idUser);
    }


    public Optional<Task> getTaskDao(int id) {
        return taskDao.findById(id);
    }

    @Transactional
    public Task insertTask(Task task) {
        return taskDao.save(task);
    }

    @Transactional
    public void deleteTask(Task task) {
        taskDao.delete(task);
    }

    public List<Task> getAllTasks() {
        return taskDao.findAll();
    }
}
