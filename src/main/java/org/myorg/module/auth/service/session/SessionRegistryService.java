package org.myorg.module.auth.service.session;

public interface SessionRegistryService {

    SessionUser auth(String username, Object id);

    SessionUser getSessionUser(String session);

    void logout(String session);

}
