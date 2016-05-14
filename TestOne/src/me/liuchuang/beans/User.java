package me.liuchuang.beans;

/**
 * Created by liuchuang on 16-5-13.
 */
public class User {
    private String id;
    private String username;
    private String password;

    public User() {
        id = null;
        username = "wustzz";
        password = "wustzz";
    }

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public java.lang.String getPassword() {
        return password;
    }
}
