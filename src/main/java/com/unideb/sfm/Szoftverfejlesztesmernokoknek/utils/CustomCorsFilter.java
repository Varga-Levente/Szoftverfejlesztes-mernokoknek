package com.unideb.sfm.Szoftverfejlesztesmernokoknek.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CustomCorsFilter {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowCredentials(true);
        corsConfig.addAllowedOrigin("*"); // Minden eredet engedélyezése
        corsConfig.addAllowedMethod("*"); // Minden HTTP metódus engedélyezése (GET, POST, stb.)
        corsConfig.addAllowedHeader("*"); // Minden fejléc engedélyezése

        CorsConfigurationSource source = request -> corsConfig;

        return new CorsWebFilter(source);
    }
}
