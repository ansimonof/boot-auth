package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.AnonymousSource;
import org.myorg.modules.access.context.Context;

public class UnauthenticatedContext extends Context<AnonymousSource> {

    public UnauthenticatedContext() {
        super(new AnonymousSource());
    }
}
