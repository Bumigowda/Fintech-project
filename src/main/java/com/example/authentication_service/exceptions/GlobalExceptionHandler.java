package com.example.authentication_service.exceptions;

import com.example.authentication_service.controllers.response.GenericExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GenericExceptionResponse> handleNotFoundException(EntityNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new GenericExceptionResponse()
                        .setMessage(exception.getMessage())
                        .setPath(request.getRequestURI())
                        .setStatusCode(HttpStatus.NOT_FOUND.toString())
                        .setTimeStamp(new Date(System.currentTimeMillis()))
                );
    }

    @ExceptionHandler
    public ResponseEntity<GenericExceptionResponse> handleBadRequestException(BadRequestException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new GenericExceptionResponse()
                        .setMessage(exception.getMessage())
                        .setPath(request.getRequestURI())
                        .setStatusCode(HttpStatus.BAD_REQUEST.toString())
                        .setTimeStamp(new Date(System.currentTimeMillis()))
                );
    }

    @ExceptionHandler
    public ResponseEntity<GenericExceptionResponse> notAuthenticatedException(UserNotAuthenticatedException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new GenericExceptionResponse()
                        .setMessage(exception.getMessage())
                        .setPath(request.getRequestURI())
                        .setStatusCode(HttpStatus.UNAUTHORIZED.toString())
                        .setTimeStamp(new Date(System.currentTimeMillis()))
                );
    }
}
