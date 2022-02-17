package org.myorg.module.auth.service.session;

import lombok.Getter;

@Getter
public class SessionUser {

    private String uuid;
    private String username;
    private Object id;

    public SessionUser(String uuid, String username, Object id) {
        this.uuid = uuid;
        this.username = username;
        this.id = id;
    }
}
