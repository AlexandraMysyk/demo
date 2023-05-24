package com.example.demo.Repositories;

import com.example.demo.entities.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextDao extends JpaRepository<Text, Integer> {
    @Query(value = "SELECT * FROM text WHERE complexity_level=?", nativeQuery = true)
    List<Text> findByLevel(String complexityLevel);

    @Query(value = "UPDATE ? SET content=?", nativeQuery = true)
    Text updateText(Text text, String content);

    @Query(value = "SELECT * FROM text WHERE id_text=?", nativeQuery = true)
    Text findById(int id);
}
