package com.school;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usersApi")
public class MyController {
    
    private List<String> users = List.of("Prasunamba", "Meher", "Kom");

    @GetMapping
    public List<String> getUsers() {
        // This correctly returns a JSON array: ["Prasunamba", "Meher", "Kom"]
        return users; 
    }
}
