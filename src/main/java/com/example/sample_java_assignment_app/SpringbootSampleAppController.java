package com.example.sample_java_assignment_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootSampleAppController {

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return "Invalid user";
        }
        return "Please input your credentials for login...";
    }

    @GetMapping("/register")
    public String register() {
        return "Please follow registration process...";
    }
}
