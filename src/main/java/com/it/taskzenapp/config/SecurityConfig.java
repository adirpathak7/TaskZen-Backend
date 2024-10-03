/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.it.taskzenapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author Aditya Pathak R
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and() // Enable CORS
                .csrf().disable() // Disable CSRF for simplicity (enable in production)
                .authorizeRequests()
                // Permit all HTTP methods (GET, POST, PUT, DELETE, PATCH) for these APIs
                .antMatchers(HttpMethod.GET, "/api/**").permitAll() // Allow GET requests for all /api/ paths
                .antMatchers(HttpMethod.POST, "/api/**").permitAll() // Allow POST requests
                .antMatchers(HttpMethod.PUT, "/api/**").permitAll() // Allow PUT requests
                .antMatchers(HttpMethod.DELETE, "/api/**").permitAll() // Allow DELETE requests
                .antMatchers(HttpMethod.PATCH, "/api/**").permitAll() // Allow PATCH requests
                .antMatchers(HttpMethod.HEAD, "/api/**").permitAll() // Allow HEAD requests
                // Other URLs that should be public can be added here as well
                .antMatchers("/login").permitAll() // Allow access to login page
                .anyRequest().authenticated() // All other requests require authentication
                .and()
                .formLogin()
                .loginPage("/login") // Custom login page
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080"); // Allow your frontend origin
        configuration.addAllowedMethod("*"); // Allow all HTTP methods
        configuration.addAllowedHeader("*"); // Allow all headers
        configuration.setAllowCredentials(true); // Allow credentials (cookies, authorization headers, etc.)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply CORS settings to all endpoints
        return source;
    }
}
