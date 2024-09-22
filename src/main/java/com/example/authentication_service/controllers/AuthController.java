package com.example.authentication_service.controllers;

import com.example.authentication_service.controllers.request.AuthorizationRequest;
import com.example.authentication_service.controllers.request.UserRequest;
import com.example.authentication_service.entities.UserEntity;
import com.example.authentication_service.exceptions.BadRequestException;
import com.example.authentication_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/access")
    public ResponseEntity<?> getAuthorizationToken(@RequestBody AuthorizationRequest request) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        //  if the user is not authenticated
        if (!authentication.isAuthenticated()) {

        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(authentication);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> creteNewUser(@RequestBody UserRequest userRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.userService.saveNewUser(userRequest));
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<UserEntity> getUserDetails(@PathVariable(name = "user_id") String userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.userService.getUserByUserId(userId));
    }
}
