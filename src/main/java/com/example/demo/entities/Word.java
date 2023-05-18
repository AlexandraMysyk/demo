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

    private byte[] picture;

    private String extension;
    @ManyToMany
    @JoinColumn(name = "id")
    private List<PersonalDictionary> personalDictionaries;

    public Word() {
    }

    public Word(int id, String name, String meaning, String translation, byte[] picture, String extension) {
        this.id_word = id;
        this.name = name;
        this.meaning = meaning;
        this.translation = translation;
        this.picture = picture;
        this.extension = extension;
    }

    public Word(int id, String name, String meaning, String translation, byte[] picture, String extension, List<PersonalDictionary> personalDictionaries) {
        this.id_word = id;
        this.name = name;
        this.meaning = meaning;
        this.translation = translation;
        this.picture = picture;
        this.extension = extension;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
                ", picture=" + Arrays.toString(picture) +
                ", extension='" + extension + '\'' +
                '}';
    }
}
