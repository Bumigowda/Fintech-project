package com.example.authentication_service.exceptions;

public class BadRequestException extends RuntimeException {
    private String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BadRequestException setMessage(String message) {
        this.message = message;
        return this;
    }
}
