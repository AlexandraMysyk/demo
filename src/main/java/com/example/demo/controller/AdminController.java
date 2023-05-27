package com.example.demo.controller;

import com.example.demo.entities.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/checkAdminIfExists/{email}")
    public ResponseEntity<Admin> checkAdminIfExists(@RequestBody @PathVariable String email){
        return new ResponseEntity<>(adminService.getAdminByEmail(email), HttpStatus.OK);
    }
}
