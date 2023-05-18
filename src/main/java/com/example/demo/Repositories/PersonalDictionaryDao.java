package com.example.demo.Repositories;

import com.example.demo.entities.PersonalDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDictionaryDao extends JpaRepository<PersonalDictionary, Integer> {

}
