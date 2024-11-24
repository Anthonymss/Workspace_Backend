package com.coworking.management_user.configuration.security;

<<<<<<< HEAD
import com.coworking.management_user.configuration.config.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
=======
import lombok.AllArgsConstructor;
>>>>>>> anthony
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
<<<<<<< HEAD
    private final String urlFronend;
=======
>>>>>>> anthony

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/management/api/**")
<<<<<<< HEAD
                .allowedOrigins(urlFronend)
=======
                .allowedOrigins("http://localhost:5173","https://workspace-umber-mu.vercel.app","*")
>>>>>>> anthony
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
