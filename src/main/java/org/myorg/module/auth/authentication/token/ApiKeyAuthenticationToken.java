package org.myorg.module.auth.authentication.token;

import org.myorg.module.auth.access.context.ApiKeyAuthenticatedContext;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

public class ApiKeyAuthenticationToken extends CustomAbstractAuthenticationToken {

    private String apiKey;
    private ApiKeyAuthenticatedContext context;

    public ApiKeyAuthenticationToken(String apiKey,
                                      Collection<? extends GrantedAuthority> authorities,
                                      ApiKeyAuthenticatedContext context) {
        super(authorities);
        this.apiKey = apiKey;
        this.context = context;
    }

    public ApiKeyAuthenticationToken(String session) {
        super(new HashSet<>());
        this.apiKey = session;
    }

    @Override
    public Object getCredentials() {
        return apiKey;
    }

    @Override
    public Object getPrincipal() {
        return context;
    }
}
