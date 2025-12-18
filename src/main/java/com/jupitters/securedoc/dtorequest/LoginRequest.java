package com.jupitters.securedoc.dtorequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class LoginRequest {
    @Email(message = "Invalid email address!")
    private String email;
    @NotEmpty(message = "Password name cannot be empty or null!")
    private String password;
}
