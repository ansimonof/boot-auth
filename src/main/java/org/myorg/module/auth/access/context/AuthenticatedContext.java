package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.Source;

public abstract class AuthenticatedContext<S extends Source> extends Context<S> {

    public AuthenticatedContext(S source) {
        super(source);
    }
}
