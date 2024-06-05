package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serving images from the templates/img directory
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/templates/img/");

        // Serving CSS from the templates/css directory
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/templates/css/");
    }
}

