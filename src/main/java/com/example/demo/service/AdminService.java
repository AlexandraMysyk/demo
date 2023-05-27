package com.example.demo.service;

import com.example.demo.Repositories.AdminDao;
import com.example.demo.entities.Admin;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminDao adminDao;

    @Autowired
    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }


    public int getAdminByEmail(String email, String password){
        return adminDao.findByEmail(email, password);
    }
    public Admin getAdminById(int id){
        return adminDao.findById(id);
    }

    @Transactional
    public void insertAdmin(Admin admin) {
        adminDao.save(admin);
    }

    @Transactional
    public void deleteAdmin(Admin admin) {
        adminDao.delete(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminDao.findAll();
    }

}
