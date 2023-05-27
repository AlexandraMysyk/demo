package com.example.demo.Repositories;

import com.example.demo.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
@Query(value="SELECT id_admin FROM admin WHERE email=? and password=?",nativeQuery = true)
    int findByEmail(String email,String password);
    @Query(value="SELECT * FROM admin WHERE id_admin=?",nativeQuery = true)
    Admin findById(int id);

}
