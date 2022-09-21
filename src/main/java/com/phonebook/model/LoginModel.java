package com.phonebook.model;

public class LoginModel {
    private String username;
    private String password;
    private static int id;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
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
    public static int getId() {

        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
