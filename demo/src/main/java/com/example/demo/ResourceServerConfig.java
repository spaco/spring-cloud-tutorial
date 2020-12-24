package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Log4j2
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private String sign_key = "190coder.cn"; // jwt签名密钥

//    @Bean
//    @ConditionalOnMissingBean(TokenStore.class)
//    public TokenStore jwtTokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
//        //签名
//        accessTokenConverter.setSigningKey("dev");
//        return accessTokenConverter;
//    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //配置受保护的资源
        http.authorizeRequests()
                .antMatchers("/api/user/**")
                .authenticated()
                .anyRequest()
                .permitAll();
    }
//
//    @Value("${security.oauth2.client.client-id}")
//    private String clientId;
//
//    @Value("${security.oauth2.client.client-secret}")
//    private String secret;
//
//    @Value("${security.oauth2.authorization.check-token-access}")
//    private String checkTokenEndpointUrl;

    public RemoteTokenServices tokenService() {
//        log.info("clientId {}",clientId);
        RemoteTokenServices tokenService = new RemoteTokenServices();
        // 携带客户端id和客户端安全码
        tokenService.setClientId("admin_client_id");
        tokenService.setClientSecret("admin_client_secret");
        // 校验端点/接⼝设置
        tokenService.setCheckTokenEndpointUrl("http://localhost:8088/oauth/check_token");

        return tokenService;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .tokenServices(tokenService())
                .resourceId("gateway")
                .stateless(true);
    }
}
