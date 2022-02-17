package org.myorg.module.auth.service.session;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SessionRegistryServiceImpl implements SessionRegistryService {

    private final Cache<String, SessionUser> sessions;

    public SessionRegistryServiceImpl(@Value("${module.auth.session-timeout}") long sessionExpire) {
        this.sessions = CacheBuilder.newBuilder()
                .expireAfterAccess(sessionExpire, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public SessionUser auth(String username, Object id) {
        String session = UUID.randomUUID().toString().replaceAll("-", "");
        SessionUser sessionUser = new SessionUser(session, username, id);
        sessions.put(session, sessionUser);

        return sessionUser;
    }

    @Override
    public SessionUser getSessionUser(String session) {
        return sessions.getIfPresent(session);
    }

    @Override
    public void logout(String session) {
        sessions.invalidate(session);
    }
}
