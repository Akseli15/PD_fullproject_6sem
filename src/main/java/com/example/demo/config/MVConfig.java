package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serving images from the resources/templates/img directory
        registry.addResourceHandler("/templates/img/**")
                .addResourceLocations("classpath:/templates/img/");

        // Serving CSS from the resources/templates/css directory
        registry.addResourceHandler("/templates/css/**")
                .addResourceLocations("classpath:/templates/css/");
    }
}
