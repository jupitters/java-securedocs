package com.jupitters.securedoc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jupitters.securedoc.entity.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private Long createdBy;
    private Long updatedBy;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String bio;
    private String imageUrl;
    private String qrCodeImageUri;
    private String lastLogin;
    private String createdAt;
    private String updatedAt;
    private String role;
    private String authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private Boolean mfa;
}
