package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.ApiKeySource;

public class ApiKeyAuthenticatedContext<S extends ApiKeySource> extends AuthenticatedContext<S> {

    public ApiKeyAuthenticatedContext(S source) {
        super(source);
    }
}
