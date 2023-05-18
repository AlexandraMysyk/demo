package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class PersonalDictionary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_pd;
    @ManyToMany
    @JoinColumn(name = "id")
    private List<Word> wordList;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

    public PersonalDictionary(int id, List<Word> wordList, User user) {
        this.id_pd = id;
        this.wordList = wordList;
        this.user = user;
    }

    public PersonalDictionary() {
    }

    public int getId_pd() {
        return id_pd;
    }

    public void setId_pd(int id) {
        this.id_pd = id;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PersonalDictionary{" +
                "id=" + id_pd +
                ", wordList=" + wordList +
                ", user=" + user +
                '}';
    }
}
