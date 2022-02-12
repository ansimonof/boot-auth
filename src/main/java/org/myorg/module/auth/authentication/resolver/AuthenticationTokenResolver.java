package org.myorg.module.auth.authentication.resolver;

import org.myorg.module.auth.authentication.token.CustomAbstractAuthenticationToken;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationTokenResolver {

    boolean supports(HttpServletRequest request);

    CustomAbstractAuthenticationToken createToken(HttpServletRequest request);

    String getName();
}
