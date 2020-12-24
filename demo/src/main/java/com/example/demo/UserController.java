package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

// https://github.com/spring-cloud/spring-cloud-gateway/issues/478
    @GetMapping("/api/user/login-user")
    public Object loginUser(Authentication authentication)
    {
        return authentication.getPrincipal();
    }
}
