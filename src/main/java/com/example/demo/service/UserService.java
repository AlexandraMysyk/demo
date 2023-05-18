package com.example.demo.service;

import com.example.demo.Repositories.UserDao;
import com.example.demo.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> getUserDao(int id) {
        return userDao.findById(id);
    }

    @Transactional
    public User insertUser(User user) {
        return userDao.save(user);
    }

    @Transactional
    public User editUser(User user, int id) {
        return userDao.editUserByid(user.getName(), user.getEmail(), user.getPassword(), id);
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
