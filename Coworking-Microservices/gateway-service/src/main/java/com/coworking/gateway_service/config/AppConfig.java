package com.coworking.gateway_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${url.fronend}")
    private String url_fronend;
    @Bean
    public String urlFronend() {
        return url_fronend;
    }
}