package com.bezkoder.spring.jpa.h2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${FRONTEND_URL:*}")
    private String frontendUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if ("*".equals(frontendUrl)) {
            registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
        } else {
            registry.addMapping("/**").allowedOrigins(frontendUrl).allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
        }
    }
}
