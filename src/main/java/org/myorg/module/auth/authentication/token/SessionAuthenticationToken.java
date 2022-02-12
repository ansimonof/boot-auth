package org.myorg.module.auth.authentication.token;

import org.myorg.module.auth.access.context.UserSessionAuthenticatedContext;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

public class SessionAuthenticationToken extends CustomAbstractAuthenticationToken {

    private String session;
    private UserSessionAuthenticatedContext context;

    public SessionAuthenticationToken(String session,
                                      Collection<? extends GrantedAuthority> authorities,
                                      UserSessionAuthenticatedContext context) {
        super(authorities);
        this.session = session;
        this.context = context;
    }

    public SessionAuthenticationToken(String session) {
        super(new HashSet<>());
        this.session = session;
    }

    @Override
    public Object getCredentials() {
        return session;
    }

    @Override
    public Object getPrincipal() {
        return context;
    }
}

