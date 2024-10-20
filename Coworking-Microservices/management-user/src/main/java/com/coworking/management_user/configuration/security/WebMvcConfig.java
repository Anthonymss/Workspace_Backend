package com.coworking.management_user.configuration.security;

import com.coworking.management_user.configuration.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final String urlFronend;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/management/api/**")
                .allowedOrigins(urlFronend)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
