package com.jupitters.securedoc.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User extends Auditable{
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phone;
    private String bio;
    private String imageUrl;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean enabled;
    private Boolean mfa;
    private String qrCodeSecret;
    private String qrCodeImageUri;
    private String roles;
}
