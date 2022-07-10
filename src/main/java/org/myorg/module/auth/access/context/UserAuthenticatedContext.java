package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.UserSource;

public class UserAuthenticatedContext<S extends UserSource> extends AuthenticatedContext<S> {

    public UserAuthenticatedContext(S source) {
        super(source);
    }
}
