package com.example.authentication_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private String userId;

    @Column(nullable = false)
    @JsonProperty("first_name")
    private String firstName;

    @Column(nullable = true)
    @JsonProperty("last_name")
    private String lastName;

    @Column(columnDefinition = "CHAR(36)", nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    @JsonProperty("email_address")
    private String emailAddress;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty("user_roles")
    @Column(nullable = false)
    private String userRoles;

    private boolean accountExpired = false;
    private boolean accountActive = true;
    private boolean accountDisabled = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public UserEntity() {
        Date date = new Date(System.currentTimeMillis());
        this.createdOn = date;
        this.updatedOn = date;
    }

    public String getUserId() {
        return userId;
    }

    public UserEntity setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public UserEntity setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public UserEntity setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
        return this;
    }

    public boolean isAccountActive() {
        return accountActive;
    }

    public UserEntity setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
        return this;
    }

    public boolean isAccountDisabled() {
        return accountDisabled;
    }

    public UserEntity setAccountDisabled(boolean accountDisabled) {
        this.accountDisabled = accountDisabled;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public UserEntity setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public UserEntity setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public List<GrantedAuthority> getUserRoles() {
        return Arrays.stream(this.userRoles.split(","))
                .map(String::trim)
                .map(String::toUpperCase)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public UserEntity setUserRoles(String userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
