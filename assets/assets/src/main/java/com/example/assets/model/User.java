package com.example.assets.model;

public class User {

    private String userName;
    private String password;
    private Boolean authenticated;

    public User(String userName, String password, Boolean authenticated) {
        this.userName = userName;
        this.password = password;
        this.authenticated = authenticated;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
