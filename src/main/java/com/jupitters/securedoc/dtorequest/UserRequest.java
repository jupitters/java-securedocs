package com.jupitters.securedoc.dtorequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String bio;
    private String phone;
}
