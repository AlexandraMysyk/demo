package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordToDictionaryDao {
    @Query(value = "INSERT INTO word_to_dictionary(id_word_dict, personal_dictionary_id_pd, word_id_word) VALUE (?,(SELECT id_pd FROM personal_dictionary WHERE user_id_user=?),(SELECT word.id_word FROM word WHERE word.meaning=? and word.name=? and word.picture=? and word.translation=? and word.content=?))", nativeQuery = true)
    void insertByUserId(int wordToDictId,int userId,String meaning, String name, byte[] picture,String translation, String content);
}
