package com.example.authentication_service.services;

import com.example.authentication_service.controllers.request.UserRequest;
import com.example.authentication_service.entities.UserEntity;
import com.example.authentication_service.exceptions.BadRequestException;
import com.example.authentication_service.exceptions.EntityNotFoundException;
import com.example.authentication_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity getUserByUsername(String username) {
        Optional<UserEntity> userEntity = this.userRepository.getUserEntityByUsername(username);
        if (userEntity.isEmpty()) {
            throw new EntityNotFoundException("User with the given username : " + username + " does not exist");
        }

        return userEntity.get();
    }

    public UserEntity saveNewUser(UserRequest user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String username = user.getUsername();
        String emailAddress = user.getEmailAddress();
        String password = user.getPassword();
        String userRoles = user.getUserRoles();

        if (firstName == null || firstName.isEmpty()) {
            throw new BadRequestException("First name can not be empty or null");
        }

        if (password == null || password.isEmpty()) {
            throw new BadRequestException("password can not be empty or null");
        }

        if (username == null || username.isEmpty()) {
            throw new BadRequestException("username can not be empty or null");
        }

        if (emailAddress == null || emailAddress.isEmpty()) {
            throw new BadRequestException("emailAddress can not be empty or null");
        }

        if (userRoles == null || userRoles.isEmpty()) {
            throw new BadRequestException("userRoles can not be empty or null");
        }

        if (this.userRepository.existsByUserIdOrUsernameOrEmailAddress(null, username, emailAddress)) {
            throw new BadRequestException("User with these details already exists");
        }

        try {
            return this.userRepository.save(new UserEntity()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUsername(username)
                    .setEmailAddress(emailAddress)
                    .setPassword(passwordEncoder.encode(password))
                    .setUserRoles(userRoles));
        }catch (Exception exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    public UserEntity getUserByUserId(String userId) {
        Optional<UserEntity> userEntity = this.userRepository.getUserEntityByUserId(userId);
        if (userEntity.isEmpty()) {
            throw new EntityNotFoundException("User does not exist");
        }

        return userEntity.get();
    }
}
