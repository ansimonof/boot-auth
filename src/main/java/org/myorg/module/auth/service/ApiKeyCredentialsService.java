package org.myorg.module.auth.service;

import org.myorg.module.auth.access.context.source.ApiKeySource;
import org.myorg.module.auth.service.credentials.ApiKeyCredentials;

public interface ApiKeyCredentialsService extends CredentialsService<ApiKeyCredentials, ApiKeySource> {

}
