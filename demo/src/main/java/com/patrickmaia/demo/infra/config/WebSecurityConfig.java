package com.patrickmaia.demo.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF (não necessário para APIs REST)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll() // Permite login sem autenticação
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
                        .requestMatchers("/role/**").permitAll()
                        .requestMatchers("/prescription/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/prescription").permitAll()
                        .requestMatchers(HttpMethod.GET, "/prescription").permitAll()
                        .requestMatchers("/medicine").permitAll()

                        .anyRequest().authenticated()) // Qualquer outra rota precisa estar autenticado
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // API sem estado

        return http.build();
    }
}



