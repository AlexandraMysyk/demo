package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_word;
    private String name;

    private String meaning;

    private String translation;

    private String picture;

    private String content;
    @ManyToMany
    @JoinTable(name = "WordToDictionary",
            joinColumns = {@JoinColumn(name = "id_word")},
            inverseJoinColumns = {@JoinColumn(name = "id_pd")})
    private List<PersonalDictionary> personalDictionaries;

    public Word() {
    }

    public Word(int id_word) {
        this.id_word = id_word;
    }

    public Word(int id, String name, String meaning, String translation, String picture, String content) {
        this.id_word = id;
        this.name = name;
        this.meaning = meaning;
        this.translation = translation;
        this.picture = picture;
        this.content = content;
    }

    public Word(int id, String name, String meaning, String translation, String picture, String content, List<PersonalDictionary> personalDictionaries) {
        this.id_word = id;
        this.name = name;
        this.meaning = meaning;
        this.translation = translation;
        this.picture = picture;
        this.content = content;
        this.personalDictionaries = personalDictionaries;
    }

    public int getId_word() {
        return id_word;
    }

    public void setId_word(int id) {
        this.id_word = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String extension) {
        this.content = extension;
    }

    public List<PersonalDictionary> getPersonalDictionaries() {
        return personalDictionaries;
    }

    public void setPersonalDictionaries(List<PersonalDictionary> personalDictionaries) {
        this.personalDictionaries = personalDictionaries;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id_word +
                ", name='" + name + '\'' +
                ", meaning='" + meaning + '\'' +
                ", translation='" + translation + '\'' +
                ", picture=" + picture +
                ", content='" + content + '\'' +
                '}';
    }
}
