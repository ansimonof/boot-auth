package org.myorg.module.auth.configuration;

import org.myorg.module.auth.authentication.provider.CustomAuthenticationProvider;
import org.myorg.module.auth.authorization.CustomAccessDecisionVoter;
import org.myorg.module.auth.authorization.DefaultAccessDecisionVoter;
import org.myorg.module.auth.filter.AuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationTokenFilter authenticationTokenFilter;
    private final List<? extends CustomAccessDecisionVoter> accessDecisionVoters;
    private final List<? extends CustomAuthenticationProvider> authenticationProviders;


    @Autowired(required = false)
    public SecurityConfiguration(AuthenticationTokenFilter authenticationTokenFilter,
                                 List<? extends CustomAccessDecisionVoter> accessDecisionVoters,
                                 List<? extends CustomAuthenticationProvider> authenticationProviders) {
        this.authenticationTokenFilter = authenticationTokenFilter;
        this.accessDecisionVoters = accessDecisionVoters;
        this.authenticationProviders = authenticationProviders;
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        if (accessDecisionVoters.isEmpty()) {
            return new UnanimousBased(Collections.singletonList(new DefaultAccessDecisionVoter()));
        } else {
            return new UnanimousBased(new ArrayList<>(accessDecisionVoters));
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .accessDecisionManager(accessDecisionManager())
                .and()
                .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        authenticationProviders.forEach(auth::authenticationProvider);
    }

}
