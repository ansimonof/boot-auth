package org.myorg.module.auth.authentication.token;

import org.myorg.module.auth.access.context.UnauthenticatedContext;

import java.util.HashSet;

public class CustomAnonymousAuthenticationToken extends CustomAbstractAuthenticationToken {

    private final UnauthenticatedContext context;

    public CustomAnonymousAuthenticationToken() {
        super(new HashSet<>());
        this.context = new UnauthenticatedContext();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return context;
    }
}
