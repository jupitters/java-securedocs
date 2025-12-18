package com.jupitters.securedoc.domain;

import com.jupitters.securedoc.entity.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApiAuthentication extends AbstractAuthenticationToken {
    private static final String PASSWORD_PROTECTED = "[PASSWORD_PROTECTED]";
    private static final String EMAIL_PROTECTED = "[EMAIL_PROTECTED]";
    private User user;
    private String email;
    private String password;
    private boolean authenticated;

    public ApiAuthentication(User user, @Nullable Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.user = user;
        this.password = PASSWORD_PROTECTED;
        this.email = EMAIL_PROTECTED;
        this.authenticated = true;
    }

    @Override
    public @Nullable Object getCredentials() {
        return null;
    }

    @Override
    public @Nullable Object getPrincipal() {
        return null;
    }
}
