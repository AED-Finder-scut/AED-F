package org.example.entities;

public class User {
    private Long userId;
    private String username;
    private String userType;
    private String password;


    public User() {
    }

    public User(Long userId, String username, String userType, String password) {
        this.userId = userId;
        this.username = username;
        this.userType = userType;
        this.password = password;
    }

    public User(Long userId) {
        this.userId = userId;
        this.username = null;
        this.userType = null;
        this.password = null;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "USER{userId = " + userId + ", username = " + username + ", userType = " + userType + ", password = " + password + "}";
    }
}
