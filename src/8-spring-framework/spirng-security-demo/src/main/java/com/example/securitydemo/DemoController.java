package com.example.securitydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/public/info")
    public String getPublicInfo() {
        return "SUCCESS: This endpoint is completely PUBLIC. No credentials needed!";
    }

    @GetMapping("/user/dashboard")
    public String getUserDashboard(Principal principal) {
        return "SUCCESS: Welcome to the USER dashboard, " + principal.getName() + "!";
    }

    @GetMapping("/admin/settings")
    public String getAdminSettings(Principal principal) {
        return "SUCCESS: Welcome to the ADMIN panel, " + principal.getName() + "!";
    }
}
