package com.spaco.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("login-user")
    public Object show(Authentication authentication) {
//        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//        jwtAccessTokenConverter.
        authentication.getPrincipal();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();

        return authentication.getPrincipal();
    }
}
