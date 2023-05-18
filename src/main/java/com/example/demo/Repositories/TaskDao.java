package com.example.demo.Repositories;

import com.example.demo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
    @Query(value = "SELECT * FROM task WHERE complexity_level=?1", nativeQuery = true)
    List<Task> findByLevel(String complexityLevel);
}
