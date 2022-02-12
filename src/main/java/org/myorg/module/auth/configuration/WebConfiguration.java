package org.myorg.module.auth.configuration;

import org.myorg.module.auth.argresolver.ContextHandlerMethodArgumentResolver;
import org.myorg.modules.web.configuration.MainWebConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
@Import({ MainWebConfiguration.class })
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ContextHandlerMethodArgumentResolver());
    }
}

