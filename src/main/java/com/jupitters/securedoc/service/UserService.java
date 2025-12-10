package com.jupitters.securedoc.service;

import com.jupitters.securedoc.entity.Role;
import com.jupitters.securedoc.entity.User;
import com.jupitters.securedoc.enums.Authority;

public interface UserService {
    void createUser(String firstName, String lastName, String email, String password);
    Role getRoleName(String name);

    void verifyAccountKey(String token);
}
