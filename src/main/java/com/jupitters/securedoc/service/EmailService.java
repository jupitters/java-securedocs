package com.jupitters.securedoc.service;

public interface EmailService {
    void sendNewAccountEmail(String name, String emailTo, String token);
    void sendPasswordResetEmail(String name, String emailTo, String token);
}
