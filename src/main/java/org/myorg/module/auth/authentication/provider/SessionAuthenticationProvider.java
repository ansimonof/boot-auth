package org.myorg.module.auth.authentication.provider;

import org.myorg.module.auth.access.context.UserSessionAuthenticatedContext;
import org.myorg.module.auth.authentication.token.SessionAuthenticationToken;
import org.myorg.module.auth.service.session.SessionCredentialsService;
import org.myorg.module.auth.service.session.SessionRegistryService;
import org.myorg.module.auth.service.session.SessionUser;
import org.myorg.modules.modules.exception.ModuleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SessionAuthenticationProvider implements CustomAuthenticationProvider {

    private final SessionRegistryService sessionRegistryService;
    private final SessionCredentialsService sessionCredentialsService;

    @Autowired
    public SessionAuthenticationProvider(SessionRegistryService sessionRegistryService, SessionCredentialsService sessionCredentialsService) {
        this.sessionRegistryService = sessionRegistryService;
        this.sessionCredentialsService = sessionCredentialsService;
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
    public boolean supports(Class<?> authentication) {
        return SessionAuthenticationToken.class.equals(authentication);
    }

    private Authentication auth(Authentication authentication) throws ModuleException {
        SessionAuthenticationToken sessionAuthToken = (SessionAuthenticationToken) authentication;
        if (sessionAuthToken.isAuthenticated()) {
            throw new InternalAuthenticationServiceException("Already authenticated");
        }

        String session = (String) sessionAuthToken.getCredentials();
        SessionUser sessionUser = sessionRegistryService.getSessionUser(session);
        if (sessionUser == null || !sessionCredentialsService.isUserExists(sessionUser.getId())) {
            throw new BadCredentialsException("Bad session: " + session);
        }

        UserSessionAuthenticatedContext context = new UserSessionAuthenticatedContext(
                session,
                sessionCredentialsService.createSource(sessionUser.getId()));
        sessionAuthToken = new SessionAuthenticationToken(session, Collections.emptySet(), context);
        sessionAuthToken.setAuthenticated(true);

        return sessionAuthToken;
    }
}
