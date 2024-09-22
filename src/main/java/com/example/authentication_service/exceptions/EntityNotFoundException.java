package com.example.authentication_service.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private String message;

    public EntityNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public EntityNotFoundException setMessage(String message) {
        this.message = message;
        return this;
    }
}
