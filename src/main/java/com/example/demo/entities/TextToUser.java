package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class TextToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_text_to_user;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Text text;

}
