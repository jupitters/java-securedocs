package com.jupitters.securedoc.security;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

@Component
@RequiredArgsConstructor
public class NewAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var user = (UsernamePasswordAuthenticationToken) authentication;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
