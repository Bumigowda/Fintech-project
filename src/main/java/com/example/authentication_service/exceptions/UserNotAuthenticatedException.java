package com.example.authentication_service.exceptions;

public class UserNotAuthenticatedException extends RuntimeException {
    private String message;

    public UserNotAuthenticatedException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public UserNotAuthenticatedException setMessage(String message) {
        this.message = message;
        return this;
    }
}
