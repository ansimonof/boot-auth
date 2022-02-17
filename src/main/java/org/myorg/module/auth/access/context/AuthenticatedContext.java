package org.myorg.module.auth.access.context;

import org.myorg.modules.access.context.source.Source;
import org.myorg.modules.access.context.Context;

public abstract class AuthenticatedContext<S extends Source> extends Context<S> {

    public AuthenticatedContext(S source) {
        super(source);
    }
}
