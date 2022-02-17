package org.myorg.module.auth.exception;

import org.myorg.modules.access.context.Context;
import org.myorg.modules.access.context.source.Source;
import org.myorg.modules.modules.exception.ModuleException;

import java.util.HashMap;

public class AuthExceptionBuilder {

    public static ModuleException buildInvalidAuthenticationContextException(Class<? extends Context> provided, Class<? extends Context> needed) {
        return new ModuleException("invalid_authentication_context", new HashMap<String, Object>() {{
            put("provided", provided);
            put("needed", needed);
        }});
    }

    public static ModuleException buildInvalidRequestSourceException(Class<? extends Source> provided, Class<? extends Source> needed) {
        return new ModuleException("invalid_request_source", new HashMap<String, Object>() {{
            put("provided", provided);
            put("needed", needed);
        }});
    }

}
