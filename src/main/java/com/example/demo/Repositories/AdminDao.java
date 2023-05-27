package com.example.demo.Repositories;

import com.example.demo.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
@Query(value="SELECT id_admin, email, name, password FROM admin WHERE email=?",nativeQuery = true)
    Admin findByEmail(String email);
}
