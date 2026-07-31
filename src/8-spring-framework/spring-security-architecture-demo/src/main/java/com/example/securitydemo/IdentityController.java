package com.example.securitydemo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class IdentityController {

    @GetMapping("/public/status")
    public String getPublicStatus() {
        return "Public portal online.";
    }

    @GetMapping("/secure/profile")
    public Map<String, Object> getSecureProfile() {
        System.out.println("[Controller] Step 5: Inside secure endpoint logic. Reading thread context memory...");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        String username = authentication.getName();
        String activeRoles = authentication.getAuthorities().toString();
        boolean isAuthenticated = authentication.isAuthenticated();

        return Map.of(
            "message", "Access approved via active token details",
            "extractedUsername", username,
            "assignedRoles", activeRoles,
            "verificationStatus", isAuthenticated
        );
    }
}
