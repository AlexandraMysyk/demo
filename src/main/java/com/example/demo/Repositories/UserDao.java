package com.example.demo.Repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Query(value = "UPDATE user SET name=?, email=?, password=? WHERE id_user=? ", nativeQuery = true)
    User editUserByid(String name, String email, String password, int id);
    @Query(value="SELECT id_user,email,name,password,id_pd FROM user,personal_dictionary WHERE id_pd=personal_dictionary_id_pd AND email=?", nativeQuery = true)
    User findByEmail(String email);
    @Query(value = "DELETE FROM user WHERE id_user=?", nativeQuery = true)
    User deleteUserById(int id);
}
