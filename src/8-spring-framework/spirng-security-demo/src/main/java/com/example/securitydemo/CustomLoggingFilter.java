package com.example.securitydemo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class CustomLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        
        // Log incoming request details before passing it down the filter chain
        System.out.println("[Custom Filter] Intercepted Request: " + request.getMethod() + " " + request.getRequestURI());
        
        // Continue execution of the remaining filters in the chain
        filterChain.doFilter(request, response);
        
        // Log outgoing response details after the chain completes execution
        System.out.println("[Custom Filter] Intercepted Response Status: " + response.getStatus());
    }
}
