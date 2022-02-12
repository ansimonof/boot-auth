package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.AnonymousSource;

public class UnauthenticatedContext extends Context<AnonymousSource> {

    public UnauthenticatedContext() {
        super(new AnonymousSource());
    }
}
