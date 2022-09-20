package com.phonebook.model;

public class LoginModel {
    private String username;
    private String password;
    private int id;

    public LoginModel(String username, String password , int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return password;
    }
    public void setPass(String password) {
        this.password = password;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
