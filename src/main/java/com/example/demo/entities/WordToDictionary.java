package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class WordToDictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_word_dict;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Word word;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private PersonalDictionary personalDictionary;
}
