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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
