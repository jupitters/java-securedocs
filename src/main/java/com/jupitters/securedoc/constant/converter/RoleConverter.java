package com.jupitters.securedoc.constant.converter;

import com.jupitters.securedoc.enums.Authority;
import jakarta.persistence.AttributeConverter;
import org.springframework.security.core.authority.AuthorityUtils;

public class RoleConverter implements AttributeConverter<Authority, String> {

    @Override
    public String convertToDatabaseColumn(Authority authority) {
        return "";
    }

    @Override
    public Authority convertToEntityAttribute(String s) {
        return null;
    }
}
