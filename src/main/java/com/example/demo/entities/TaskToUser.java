package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class TaskToUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_tasktouser;

    private String content;

    private int mark;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Task task;

    public TaskToUser() {
    }

    public TaskToUser(int id_tasktouser) {
        this.id_tasktouser = id_tasktouser;
    }

    public TaskToUser(int id, String content, int mark, User user, Task task) {
        this.id_tasktouser = id;
        this.content = content;
        this.mark = mark;
        this.user = user;
        this.task = task;
    }

    public int getId_tasktouser() {
        return id_tasktouser;
    }

    public void setId_tasktouser(int id) {
        this.id_tasktouser = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskToUser{" +
                "id=" + id_tasktouser +
                ", content='" + content + '\'' +
                ", mark=" + mark +
                ", user=" + user +
                ", task=" + task +
                '}';
    }
}
