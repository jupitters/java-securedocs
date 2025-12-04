package com.jupitters.securedoc.enums;

public enum Authority {
    USER(""),
    ADMIN(""),
    SUPER_ADMIN(""),
    MANAGER("");

    private final String value;

    Authority(String value) {
        this.value = value;
    }
}
