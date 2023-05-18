package com.example.demo.Repositories;

import com.example.demo.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordDao extends JpaRepository<Word, Integer> {

}
