package org.myorg.module.auth.service.session;

import org.myorg.module.auth.access.context.source.UserSource;
import org.myorg.modules.modules.exception.ModuleException;

public interface SessionCredentialsService {

    boolean isUserExists(Object id) throws ModuleException;

    UserSource createSource(Object id) throws ModuleException;
}
