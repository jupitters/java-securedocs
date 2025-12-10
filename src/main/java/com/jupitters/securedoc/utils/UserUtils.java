package com.jupitters.securedoc.utils;

import com.jupitters.securedoc.entity.Role;
import com.jupitters.securedoc.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.time.LocalTime.now;
import static org.apache.logging.log4j.util.Strings.EMPTY;

public class UserUtils {
    public static User createUserEntity(String firstName, String lastName, String email, Role role) {
        return User.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .lastLogin(LocalDateTime.from(now()))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .mfa(false)
                .enabled(false)
                .loginAttempts(0)
                .qrCodeSecret(String.valueOf(EMPTY))
                .phone(String.valueOf(EMPTY))
                .bio(String.valueOf(EMPTY))
                .imageUrl("https://cdn-icons-png.flaticon.com/512/149/149071.png")
                .role(role)
                .build();
    }
}
