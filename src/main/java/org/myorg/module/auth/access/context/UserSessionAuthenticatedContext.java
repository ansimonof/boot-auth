package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.UserSource;

public class UserSessionAuthenticatedContext extends UserAuthenticatedContext {

    public UserSessionAuthenticatedContext(UserSource source) {
        super(source);
    }
}
