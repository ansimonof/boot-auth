package org.myorg.module.auth.access.context;

import org.myorg.module.auth.access.context.source.ApiKeySource;

public class ApiKeyAuthenticatedContext extends AuthenticatedContext<ApiKeySource> {

    public ApiKeyAuthenticatedContext(ApiKeySource source) {
        super(source);
    }
}
