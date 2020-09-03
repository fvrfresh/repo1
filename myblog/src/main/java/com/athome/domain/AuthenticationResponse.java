package com.athome.domain;

/**
 * @ClassName AuthenticationResponse
 * @Description TODO
 * @Author zhang
 * @Date 2020/9/1 15:17
 * @Version 1.0
 */
public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
