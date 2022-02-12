package org.myorg.module.auth.authentication.resolver;

import org.myorg.module.auth.authentication.token.ApiKeyAuthenticationToken;
import org.myorg.module.auth.authentication.token.CustomAbstractAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class ApiKeyAuthenticationTokenResolver implements AuthenticationTokenResolver {

    private static final String API_KEY = "api_key";

    private String getApiKey(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (Objects.equals(cookie.getName(), API_KEY)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public boolean supports(HttpServletRequest request) {
        return getApiKey(request) != null;
    }

    @Override
    public CustomAbstractAuthenticationToken createToken(HttpServletRequest request) {
        return new ApiKeyAuthenticationToken(getApiKey(request));
    }

    @Override
    public String getName() {
        return "Api key resolver";
    }
}
