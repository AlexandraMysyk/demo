package com.example.demo.service;

import com.example.demo.Repositories.TaskAnswersListDao;
import com.example.demo.entities.TaskAnswersList;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskAnswersListService {
    private final TaskAnswersListDao taskAnswersListDao;

    @Autowired
    public TaskAnswersListService(TaskAnswersListDao taskAnswersListDao) {
        this.taskAnswersListDao = taskAnswersListDao;
    }

    public Optional<TaskAnswersList> getTaskAnswersListDao(int id) {
        return taskAnswersListDao.findById(id);
    }

    @Transactional
    public void insertTaskAnswersList(TaskAnswersList taskAnswersList) {
        taskAnswersListDao.save(taskAnswersList);
    }

    @Transactional
    public void deleteTaskAnswersList(TaskAnswersList taskAnswersList) {
        taskAnswersListDao.delete(taskAnswersList);
    }

    public List<TaskAnswersList> getAllTexts() {
        return taskAnswersListDao.findAll();
    }
}
