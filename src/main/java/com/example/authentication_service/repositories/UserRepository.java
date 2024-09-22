package com.example.authentication_service.repositories;

import com.example.authentication_service.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public Optional<UserEntity> getUserEntityByUsername(String username);
    public Optional<UserEntity> getUserEntityByUserId(String userId);
    public boolean existsByUserIdOrUsernameOrEmailAddress(String userId, String username, String emailAddress);
}
