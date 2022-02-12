package org.myorg.module.auth.service.credentials;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordCredentials implements Credentials {

    private String username;

    private String passwordHash;
}
