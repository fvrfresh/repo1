package com.athome.domain;

/**
 * @ClassName AuthenticationRequest
 * @Description TODO
 * @Author zhang
 * @Date 2020/9/1 15:15
 * @Version 1.0
 */
public class AuthenticationRequest {
    private String username;
    private String password;

    public AuthenticationRequest(String uusername, String password) {
        this.username = uusername;
        this.password = password;
    }

    public AuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "Uusername='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
