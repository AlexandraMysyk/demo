package com.example.demo.Repositories;

import com.example.demo.entities.Word;
import com.example.demo.entities.WordToDictionary;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordToDictionaryDao extends JpaRepository<WordToDictionary, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO word_to_dictionary(id_word_dict, personal_dictionary_id_pd, word_id_word, id_word, id_pd) VALUE (?,(SELECT id_pd FROM personal_dictionary WHERE user_id_user=?),(SELECT word.id_word FROM word WHERE word.meaning=? and word.name=? and word.picture=? and word.translation=? and word.content=? LIMIT 1), ?, ?)", nativeQuery = true)
    void insertByUserId(int wordToDictId,int userId,String meaning, String name, String picture,String translation, String content,int id_word, int id_pd);
}
