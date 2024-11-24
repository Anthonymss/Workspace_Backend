package com.coworking.auth_service.configuration.security;

import com.coworking.auth_service.configuration.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
<<<<<<< HEAD
    private final String urlFronend;

    @Autowired
    public WebMvcConfig(AppConfig appConfig) {
        this.urlFronend = appConfig.urlFronend();
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/auth/api/**")
                .allowedOrigins(urlFronend)
=======

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/auth/api/**")
                .allowedOrigins("http://localhost:5173","https://workspace-umber-mu.vercel.app","*")
>>>>>>> anthony
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
