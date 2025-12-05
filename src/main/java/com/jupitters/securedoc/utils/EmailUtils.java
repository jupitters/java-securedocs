package com.jupitters.securedoc.utils;

public class EmailUtils {
    public String getResetPasswordMessage(String name, String host, String token) {
        return "Hello" + name + ",\n\n" +
                "Your new account has been created. " +
                "Please click on the link below to verify your account.\n\n" +
                getVerificationUrl(host, token) +
                "\n\nThe Support Team";
    }

    public String getVerificationUrl(String host, String token) {
    }
}
