package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_user;

    private String name;

    private String password;

    private String email;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private PersonalDictionary personalDictionary;
    @ManyToMany
    @JoinTable(name = "TaskToUser",
            joinColumns = {@JoinColumn(name="id_user")},
            inverseJoinColumns = {@JoinColumn(name="id_task")})
    private List<Task> taskList;
    @ManyToMany
    @JoinTable(name = "TextToUser",
            joinColumns = {@JoinColumn(name="id_user")},
            inverseJoinColumns = {@JoinColumn(name="id_text")})
    private List<Text> textList;

    public User() {
    }

    public User(int id_user) {
        this.id_user = id_user;
    }

}
