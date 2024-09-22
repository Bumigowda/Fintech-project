package com.example.authentication_service.securityconfig;

import com.example.authentication_service.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthUserDetails implements UserDetails {

    private final UserEntity userEntity;

    public AuthUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userEntity.getUserRoles();
    }

    @Override
    public String getPassword() {
        return this.userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        if (this.userEntity.isAccountExpired())
            return false;
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (this.userEntity.isAccountDisabled())
            return false;
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (this.userEntity.isAccountExpired())
            return false;
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.userEntity.isAccountActive();
    }
}
