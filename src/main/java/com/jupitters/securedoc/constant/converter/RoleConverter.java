package com.jupitters.securedoc.constant.converter;

import com.jupitters.securedoc.enums.Authority;
import jakarta.persistence.AttributeConverter;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.stream.Stream;

public class RoleConverter implements AttributeConverter<Authority, String> {

    @Override
    public String convertToDatabaseColumn(Authority authority) {
        if(authority == null){
            return null;
        }
        return authority.getValue();
    }


}
