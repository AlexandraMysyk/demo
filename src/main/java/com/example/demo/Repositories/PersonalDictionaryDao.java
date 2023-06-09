package com.example.demo.Repositories;

import com.example.demo.entities.PersonalDictionary;
import com.example.demo.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonalDictionaryDao extends JpaRepository<PersonalDictionary, Integer> {
}
