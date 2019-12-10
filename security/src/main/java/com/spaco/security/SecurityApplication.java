package com.spaco.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @GetMapping("home")
    public String home() {

        return "home";
    }

    @GetMapping("welcome")
    public String welcome() {
        String username = "sd";
        return "welcome" + username;
    }
}
