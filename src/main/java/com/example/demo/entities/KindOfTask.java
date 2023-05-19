package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class KindOfTask implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_kot;
//    private String name;
//    @OneToMany
//    @JoinColumn(name = "kindOfTask")
//    private List<Task> taskOfThisKind;


    public KindOfTask(int id_kot) {
        this.id_kot = id_kot;
    }

//    public KindOfTask(int id, String name) {
//        this.id_kot = id;
//        this.name = name;
//    }
//
//    public KindOfTask(int id, String name, List<Task> taskOfThisKind) {
//        this.id_kot = id;
//        this.name = name;
//        this.taskOfThisKind = taskOfThisKind;
//    }

    public KindOfTask() {
    }
//
//    public int getId_kot() {
//        return id_kot;
//    }
//
//    public void setId_kot(int id) {
//        this.id_kot = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Task> getTaskOfThisKind() {
//        return taskOfThisKind;
//    }
//
//    public void setTaskOfThisKind(List<Task> taskOfThisKind) {
//        this.taskOfThisKind = taskOfThisKind;
//    }
//
//    @Override
//    public String toString() {
//        return "KindOfTask{" +
//                "id=" + id_kot +
//                ", name='" + name +
//                '}';
//    }
}
