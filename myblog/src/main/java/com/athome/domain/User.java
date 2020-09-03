package com.athome.domain;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/24 17:26
 * @Version 1.0
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String website;

    public User(String username) {
        this.username = username;
    }

    public User(String username, String email, String website) {
        this.username = username;
        this.email = email;
        this.website = website;
    }

    public User(int id, String username, String email, String website) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
