package com.example.authentication_service.controllers.request;

public class AuthorizationRequest {
    private String username;
    private String password;

    public AuthorizationRequest() {}

    public AuthorizationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public AuthorizationRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthorizationRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
