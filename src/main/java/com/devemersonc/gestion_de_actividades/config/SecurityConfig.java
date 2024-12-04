package com.devemersonc.gestion_de_actividades.config;

import com.devemersonc.gestion_de_actividades.security.JwtAuthenticationEntryPoint;
import com.devemersonc.gestion_de_actividades.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtFilter jwtFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/users/{id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/users/save-normal-user").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/save-admin-user").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/users/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/activities").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/activities/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/activities/{activityId}/users").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/activities/users").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/activities").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/activities/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/activities/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/inscriptions").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/inscriptions/{id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/inscriptions/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/inscriptions/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/api/inscriptions/attendance/{idInscription}").authenticated()
                        .anyRequest().authenticated())
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
