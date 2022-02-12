package org.myorg.module.auth.service.credentials;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiKeyCredentials implements Credentials {

    private String apiKey;
}
