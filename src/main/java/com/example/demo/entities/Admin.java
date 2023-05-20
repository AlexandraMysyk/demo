package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id_admin;

    private String name;

    private String password;

    private String email;
    @OneToMany(mappedBy = "admin")
    private List<Text> textList;

    public Admin() {
    }

    public Admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public Admin(int id, String name, String password, String email) {
        this.id_admin = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id) {
        this.id_admin = id;
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

    public List<Text> getTextList() {
        return textList;
    }

    public void setTextList(List<Text> textList) {
        this.textList = textList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id_admin +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", textList=" + textList +
                '}';
    }
}
