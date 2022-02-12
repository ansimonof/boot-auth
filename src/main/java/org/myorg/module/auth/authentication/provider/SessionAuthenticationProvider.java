package org.myorg.module.auth.authentication.provider;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class SessionAuthenticationProvider implements CustomAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
