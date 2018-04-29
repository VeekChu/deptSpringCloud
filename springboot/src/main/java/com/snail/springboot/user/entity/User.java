package com.snail.springboot.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private int age;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
