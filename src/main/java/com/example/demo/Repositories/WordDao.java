package com.example.demo.Repositories;

import com.example.demo.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WordDao extends JpaRepository<Word, Integer> {
    @Modifying
    @Transactional
    @Query(value="SELECT word.id_word,word.meaning,word.name,word.picture,word.translation,word.content FROM word,word_to_dictionary,personal_dictionary,user WHERE word.id_word=word_to_dictionary.id_word AND personal_dictionary.id_pd=word_to_dictionary.id_pd AND personal_dictionary.user_id_user=user.id_user AND user.id_user=?  ", nativeQuery = true)
    List<String> getAllWordsByUserId(int idUser);
//@Query(value="SELECT word.id_word FROM word WHERE word.meaning=? and word.name=? and word.picture=? and word.translation=? and word.content=?", nativeQuery = true)
//    int getIdFromWord(String meaning, String name, byte[] picture, String translation, String content );
//    @Modifying
//    @Transactional
//    @Query(value="INSERT INTO word(id_word,meaning,name,translation,content) VALUES (?,?,?,?,?);" +
//            "INSERT INTO word_to_dictionary VALUE (id_word,word.id_word=word_to_dictionary.id_word AND personal_dictionary.id_pd=word_to_dictionary.id_pd AND personal_dictionary.user_id_user=user.id_user AND user.id_user=?  ",nativeQuery = true)
//    Word saveById(int idWord, String meaning, String name, String translation, String content,int idPerDict, int userId);

}
