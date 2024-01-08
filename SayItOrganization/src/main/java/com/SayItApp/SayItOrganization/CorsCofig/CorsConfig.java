package com.SayItApp.SayItOrganization.CorsCofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000", "http://sayitreact.s3-website.eu-west-2.amazonaws.com") // Add your React app's origin
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowCredentials(true)
        .allowedHeaders("Authorization", "Content-Type") 
        .exposedHeaders("Authorization");
    }
}