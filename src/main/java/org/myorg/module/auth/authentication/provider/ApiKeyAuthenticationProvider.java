package org.myorg.module.auth.authentication.provider;

import org.myorg.module.auth.access.context.ApiKeyAuthenticatedContext;
import org.myorg.module.auth.authentication.token.ApiKeyAuthenticationToken;
import org.myorg.module.auth.service.apikey.ApiKeyCredentialsService;
import org.myorg.modules.modules.exception.ModuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApiKeyAuthenticationProvider implements CustomAuthenticationProvider {

    private final ApiKeyCredentialsService apiKeyCredentialsService;

    @Autowired
    public ApiKeyAuthenticationProvider(ApiKeyCredentialsService apiKeyCredentialsService) {
        this.apiKeyCredentialsService = apiKeyCredentialsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            return auth(authentication);
        } catch (ModuleException e) {
            throw new InternalAuthenticationServiceException(e.getMessage());
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ApiKeyAuthenticationToken.class.equals(clazz);
    }

    private Authentication auth(Authentication authentication) throws ModuleException {
        ApiKeyAuthenticationToken apiKeyAuth = (ApiKeyAuthenticationToken) authentication;
        if (apiKeyAuth.isAuthenticated()) {
            throw new InternalAuthenticationServiceException("Already authenticated");
        }

        String apiKey = (String) apiKeyAuth.getCredentials();
        if (!apiKeyCredentialsService.isApiKeyExists(apiKey)) {
            throw new BadCredentialsException("Bad API key: " + apiKey);
        }

        ApiKeyAuthenticatedContext context = new ApiKeyAuthenticatedContext(apiKeyCredentialsService.createSource(apiKey));
        apiKeyAuth = new ApiKeyAuthenticationToken(apiKey, Collections.emptySet(), context);
        apiKeyAuth.setAuthenticated(true);

        return apiKeyAuth;
    }

}
