package com.teducci.apigateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        http.csrf().disable();

        http.authorizeExchange(exchanges ->
                        exchanges
                                .and().authorizeExchange()
                                .pathMatchers("/login").permitAll()
                                .anyExchange().authenticated()
        );

        http.oauth2ResourceServer().jwt();
        return http.build();
    }

}