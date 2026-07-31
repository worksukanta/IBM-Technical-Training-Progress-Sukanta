package com.example.actuatordemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello World! Triggering app metrics data.";
    }

    // route --> /actuator
}
