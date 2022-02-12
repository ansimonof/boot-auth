package org.myorg.module.auth.service;

import org.myorg.module.auth.access.context.source.Source;
import org.myorg.module.auth.service.credentials.Credentials;
import org.myorg.modules.modules.exception.ModuleException;

public interface CredentialsService<T extends Credentials, S extends Source> {

    boolean isCorrect(T credentials) throws ModuleException;

    S createSource(T credentials) throws ModuleException;
}
