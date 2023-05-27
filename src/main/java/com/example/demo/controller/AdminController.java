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

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/checkAdminIfExists/{email}/{password}")
    public ResponseEntity<Integer> checkAdminIfExists(@RequestBody @PathVariable String email,@RequestBody @PathVariable  String password){
        return new ResponseEntity<>(adminService.getAdminByEmail(email, password),HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/checkAdmin/{id}")
    public ResponseEntity<Admin> checkAdminIfExists(@RequestBody @PathVariable int id){
        return new ResponseEntity<>(adminService.getAdminById(id),HttpStatus.OK);
    }
}
