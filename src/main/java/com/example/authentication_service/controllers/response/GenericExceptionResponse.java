package com.example.authentication_service.controllers.response;

import java.util.Date;

public class GenericExceptionResponse {
    private String message;
    private String statusCode;
    private Date timeStamp;
    private String path;

    public GenericExceptionResponse() {}

    public GenericExceptionResponse(String message, String statusCode, Date timeStamp, String path) {
        this.message = message;
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public GenericExceptionResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public GenericExceptionResponse setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public GenericExceptionResponse setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public String getPath() {
        return path;
    }

    public GenericExceptionResponse setPath(String path) {
        this.path = path;
        return this;
    }
}
