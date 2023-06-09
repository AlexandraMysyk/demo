package com.example.demo.Repositories;

import com.example.demo.entities.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextDao extends JpaRepository<Text, Integer> {
    @Query(value = "SELECT id_text, name  FROM text WHERE complexity_level=?", nativeQuery = true)
    List<String> findByLevel(String complexityLevel);
    @Modifying
    @Query(value = "UPDATE text SET text.content=? , text.name=?,text.complexity_level=? where text.id_text =?", nativeQuery = true)
    void update(String content, String nameText, String complexityLevel, int idText);
    @Query(value = "SELECT * FROM text WHERE id_text=?", nativeQuery = true)
    String findById(int id);
    @Query(value = "SELECT * FROM text", nativeQuery = true)
    List<String> findAllTexts();

    @Query(value = "SELECT id_text FROM text WHERE name=?", nativeQuery = true)
    String findByName(String name);

}
