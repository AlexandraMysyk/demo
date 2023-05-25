package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Text implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_text;
    private String content;
    private String name;

    private String complexityLevel;
    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = false)
    private Admin admin;
    @ManyToMany
    @JoinTable(name = "TextToUser",
            joinColumns = {@JoinColumn(name = "id_text")},
            inverseJoinColumns = {@JoinColumn(name = "id_user")})
    private List<User> user;

    public Text() {
    }

    public Text(int id_text) {
        this.id_text = id_text;
    }

    public Text(int id, String content, String complexityLevel, Admin admin, List<User> user, String name) {
        this.id_text = id;
        this.content = content;
        this.complexityLevel = complexityLevel;
        this.admin = admin;
        this.user = user;
        this.name = name;
    }

    public int getId_text() {
        return id_text;
    }

    public void setId_text(int id) {
        this.id_text = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComplexityLevel() {
        return complexityLevel;
    }

    public void setComplexityLevel(String complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Text{" +
                "id=" + id_text +
                ", content='" + content + '\'' +
                ", complexityLevel='" + complexityLevel + '\'' +
                ", admin=" + admin +
                '}';
    }
}
