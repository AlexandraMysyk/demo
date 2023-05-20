package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class TaskToUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_task;

    private String content;

    private int mark;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Task task;

    public TaskToUser() {
    }

    public TaskToUser(int id_task) {
        this.id_task = id_task;
    }
        public TaskToUser(int id, String content, int mark, User user, Task task) {
        this.id_task = id;
        this.content = content;
        this.mark = mark;
        this.user = user;
        this.task = task;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id) {
        this.id_task = id;
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
                "id=" + id_task +
                ", content='" + content + '\'' +
                ", mark=" + mark +
                ", user=" + user +
                ", task=" + task +
                '}';
    }
}
