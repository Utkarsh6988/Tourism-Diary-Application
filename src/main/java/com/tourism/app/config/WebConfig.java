package com.tourism.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Value;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${upload.dir}") // From application.properties
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Convert to absolute path and normalize for OS
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
        
        registry
            .addResourceHandler("/uploads/**") // URL path
            .addResourceLocations("file:" + uploadPath + "/") // Physical path
            .setCachePeriod(3600); // Cache for 1 hour (optional)
        
        System.out.println("[WebConfig] Serving uploads from: " + uploadPath);
    }
}