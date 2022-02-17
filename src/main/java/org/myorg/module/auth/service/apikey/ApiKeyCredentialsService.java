package org.myorg.module.auth.service.apikey;

import org.myorg.module.auth.access.context.source.ApiKeySource;
import org.myorg.modules.modules.exception.ModuleException;

public interface ApiKeyCredentialsService {

    boolean isApiKeyExists(String apiKey) throws ModuleException;

    ApiKeySource createSource(String apiKey) throws ModuleException;

}
