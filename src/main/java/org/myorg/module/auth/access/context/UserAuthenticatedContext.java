package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.UserSource;

public class UserAuthenticatedContext extends AuthenticatedContext<UserSource> {

    public UserAuthenticatedContext(UserSource source) {
        super(source);
    }
}
