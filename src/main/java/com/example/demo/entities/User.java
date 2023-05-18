package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class User extends Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_user;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private PersonalDictionary personalDictionary;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private TaskAnswersList taskList;
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<Text> textList;

    public User() {
    }

    public User(int id, String name, String password, String email, int id_user, PersonalDictionary personalDictionary, TaskAnswersList taskList, List<Text> textList) {
        super(id, name, password, email);
        this.id_user = id_user;
        this.personalDictionary = personalDictionary;
        this.taskList = taskList;
        this.textList = textList;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id) {
        this.id_user = id;
    }


    public PersonalDictionary getPersonalDictionary() {
        return personalDictionary;
    }

    public void setPersonalDictionary(PersonalDictionary personalDictionary) {
        this.personalDictionary = personalDictionary;
    }

    public TaskAnswersList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskAnswersList taskList) {
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
                "id=" + id_user +
                ", personalDictionary=" + personalDictionary +
                ", textList=" + textList +
                '}';
    }
}
