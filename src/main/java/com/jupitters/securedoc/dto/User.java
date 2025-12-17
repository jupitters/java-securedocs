package com.jupitters.securedoc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jupitters.securedoc.entity.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String bio;
    private Integer loginAttempts;
    private String imageUrl;
    private String qrCodeImageUri;
    private String qrCodeSecret;
    private String lastLogin;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean enabled;
    private Boolean mfa;
    private Role role;
}
