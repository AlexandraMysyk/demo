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
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_task")})
    private List<Task> taskList;
    @ManyToMany
    @JoinTable(name = "TextToUser",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_text")})
    private List<Text> textList;

    public User() {
    }

    public User(int id_user) {
        this.id_user = id_user;
    }

    public User(int id_user, String name, String password, String email, PersonalDictionary personalDictionary, List<Task> taskList, List<Text> textList) {
        this.id_user = id_user;
        this.name = name;
        this.password = password;
        this.email = email;
        this.personalDictionary = personalDictionary;
        this.taskList = taskList;
        this.textList = textList;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonalDictionary getPersonalDictionary() {
        return personalDictionary;
    }

    public void setPersonalDictionary(PersonalDictionary personalDictionary) {
        this.personalDictionary = personalDictionary;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Text> getTextList() {
        return textList;
    }

    public void setTextList(List<Text> textList) {
        this.textList = textList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", personalDictionary=" + personalDictionary +
                ", taskList=" + taskList +
                ", textList=" + textList +
                '}';
    }
}
