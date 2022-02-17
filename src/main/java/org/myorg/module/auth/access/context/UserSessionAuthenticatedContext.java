package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.UserSource;

public class UserSessionAuthenticatedContext extends UserAuthenticatedContext {

    private final String session;

    public UserSessionAuthenticatedContext(String session, UserSource source) {
        super(source);
        this.session = session;
    }

    public String getSession() {
        return session;
    }
}
