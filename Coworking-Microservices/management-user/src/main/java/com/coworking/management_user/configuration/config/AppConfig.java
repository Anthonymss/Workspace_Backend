package com.coworking.management_user.configuration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Value("${url.fronend}")
    private String url_fronend;
    @Bean
    public String urlFronend() {
        return url_fronend;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
