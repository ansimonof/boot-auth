package org.myorg.module.auth.authentication.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public abstract class CustomAbstractAuthenticationToken extends AbstractAuthenticationToken {

    public CustomAbstractAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }
}