package com.tourism.app.config;

import org.springdoc.core.models.GroupedOpenApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("tourism-api")
            .packagesToScan("com.tourism.app.controller")
            .pathsToMatch("/**")
            .build();
    }
}
