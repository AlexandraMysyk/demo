package com.example.demo.service;

import com.example.demo.Repositories.TaskToUserDao;
import com.example.demo.entities.TaskToUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskToUserService {
    private final TaskToUserDao taskToUserDao;

    @Autowired
    public TaskToUserService(TaskToUserDao taskToUserDao) {
        this.taskToUserDao = taskToUserDao;
    }

    public Optional<TaskToUser> getTaskAnswersListDao(int id) {
        return taskToUserDao.findById(id);
    }

    @Transactional
    public TaskToUser insertTaskAnswers(TaskToUser taskToUser) {
        return taskToUserDao.save(taskToUser);
    }

    @Transactional
    public void deleteTaskAnswersList(TaskToUser taskToUser) {
        taskToUserDao.delete(taskToUser);
    }

    public List<TaskToUser> getAllTexts() {
        return taskToUserDao.findAll();
    }
}
