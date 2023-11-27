package com.niit.PizzaService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppConfig {
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource corsConfigSource=new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig=new CorsConfiguration();

        corsConfig.setAllowCredentials(true);

        corsConfig.addAllowedOrigin("*");
        corsConfig.addAllowedOriginPattern("*");
        corsConfig.addAllowedHeader("*");

        corsConfig.addAllowedMethod("OPTIONS");
        corsConfig.addAllowedMethod("GET");
        corsConfig.addAllowedMethod("POST");
        corsConfig.addAllowedMethod("PUT");
        corsConfig.addAllowedMethod("DELETE");

        corsConfigSource.registerCorsConfiguration("/**",corsConfig);

        return new CorsFilter(corsConfigSource);
   }
}
