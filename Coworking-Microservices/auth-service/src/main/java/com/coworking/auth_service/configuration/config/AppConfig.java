package com.coworking.auth_service.configuration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientIdGoogle;
<<<<<<< HEAD
    @Value("${url.fronend}")
    private String urlFronend;
=======
>>>>>>> anthony
    @Bean
    public String googleClientId() {
        return clientIdGoogle;
    }
<<<<<<< HEAD
    @Bean
    public String urlFronend() {
        return urlFronend;
    }
=======

>>>>>>> anthony
}
