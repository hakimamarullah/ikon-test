package com.example.demo.dto;
/*
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 10/8/2024 3:46 PM
@Last Modified 10/8/2024 3:46 PM
Version 1.0
*/

public class PostResponse {

    private Integer userId;
    private String title;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
