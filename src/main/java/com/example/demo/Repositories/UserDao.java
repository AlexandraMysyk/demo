package com.example.demo.Repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    @Query(value = "UPDATE user SET name=?, email=?, passwort=? WHERE id_user=? ", nativeQuery = true)
    User editUserByid(String name, String email, String passwort, int id);

    @Query(value = "DELETE FROM user WHERE id_user=?", nativeQuery = true)
    User deleteUserById(int id);
}
