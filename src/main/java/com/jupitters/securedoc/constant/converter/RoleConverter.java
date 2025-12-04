package com.jupitters.securedoc.constant.converter;

import com.jupitters.securedoc.enums.Authority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Authority, String> {



    @Override
    public Authority convertToEntityAttribute(String s) {
        if(s == null){
            return null;
        }
        return Stream.of(Authority.values())
                .filter(authority -> authority.getValue().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
