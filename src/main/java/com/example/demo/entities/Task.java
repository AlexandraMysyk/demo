package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_task;

    private String taskContent;

    private String answer;

    private String complexityLevel;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private KindOfTask kindOfTask;
    @ManyToMany
    @JoinColumn(name = "id")
    private List<User> userList;

    public Task() {
    }

    public Task(int id, String taskContent, String answer, String complexityLevel) {
        this.id_task = id;
        this.taskContent = taskContent;
        this.answer = answer;
        this.complexityLevel = complexityLevel;
        //this.kindOfTask = kindOfTask;
    }


    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id) {
        this.id_task = id;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getComplexityLevel() {
        return complexityLevel;
    }

    public void setComplexityLevel(String complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public KindOfTask getKindOfTask() {
        return kindOfTask;
    }

    public void setKindOfTask(KindOfTask kindOfTask) {
        this.kindOfTask = kindOfTask;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id_task +
                ", taskContent='" + taskContent + '\'' +
                ", answer='" + answer + '\'' +
                ", complexityLevel='" + complexityLevel + '\'' +
                ", kindOfTask=" + kindOfTask +
                '}';
    }
}
