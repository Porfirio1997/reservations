package com.example.Reservations.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI config(){
        return new OpenAPI().info(new Info().title("Reservations").description("API para Reservas").version("0.1.1"));
    }
}
