package org.myorg.module.auth.service;


import org.myorg.module.auth.access.context.UserAuthenticatedContext;
import org.myorg.module.auth.access.context.source.UserSource;
import org.myorg.module.auth.service.credentials.UsernamePasswordCredentials;

public interface UsernamePasswordCredentialsService extends CredentialsService<UsernamePasswordCredentials, UserSource> {

}
