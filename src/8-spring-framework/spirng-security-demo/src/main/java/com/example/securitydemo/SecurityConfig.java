package com.example.securitydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(new CustomLoggingFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/public/**").permitAll()     
                             
                .requestMatchers("/actuator/**").hasRole("ADMIN")             
                .requestMatchers("/api/admin/**").hasRole("ADMIN")             
                .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")   
                .anyRequest().authenticated()                                   
            )
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // 1. Define a secure password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Reference the encoder when setting up mock user details
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // Raw password "password123" becomes safely hashed via BCrypt automatically
        UserDetails user = User.builder()
                .username("regularuser")
                .password(encoder.encode("password123"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("sysadmin")
                .password(encoder.encode("admin456"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
