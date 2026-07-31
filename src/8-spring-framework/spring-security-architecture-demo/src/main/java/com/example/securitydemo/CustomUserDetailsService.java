package com.example.securitydemo;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // 2. Define clear plain-text values to guarantee strings match perfectly
    private final Map<String, UserDetails> mockDatabase = Map.of(
        "john_doe", User.withUsername("john_doe")
                        .password("pass123") // ◄ Plain text
                        .roles("USER")
                        .build(),
        "admin_user", User.withUsername("admin_user")
                        .password("admin123") // ◄ Plain text
                        .roles("ADMIN")
                        .build()
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("!!! [UserDetailsService TRACE] Loading username: " + username);
        
        UserDetails user = mockDatabase.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}
