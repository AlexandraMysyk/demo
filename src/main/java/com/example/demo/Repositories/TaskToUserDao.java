package com.example.demo.Repositories;

import com.example.demo.entities.TaskToUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskToUserDao extends JpaRepository<TaskToUser, Integer> {

}
