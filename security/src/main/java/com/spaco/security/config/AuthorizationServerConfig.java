package com.spaco.security.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer
@Log4j2
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private TokenStore tokenStore;

    private JwtAccessTokenConverter jwtAccessTokenConverter;

    private JwtTokenEnhancer jwtTokenEnhancer;

    @Autowired
    public AuthorizationServerConfig(PasswordEncoder passwordEncoder,
                                     AuthenticationManager authenticationManager,
                                     UserDetailsService userDetailsService,
                                     @Qualifier("jwtTokenStore") TokenStore tokenStore,
                                     JwtAccessTokenConverter jwtAccessTokenConverter,
                                     JwtTokenEnhancer jwtTokenEnhancer) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.tokenStore = tokenStore;
        this.jwtAccessTokenConverter = jwtAccessTokenConverter;
        this.jwtTokenEnhancer = jwtTokenEnhancer;
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        //配置JWT的内容增强器
        delegates.add(jwtTokenEnhancer);
        delegates.add(jwtAccessTokenConverter);
        enhancerChain.setTokenEnhancers(delegates);

        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(tokenStore)
                .tokenEnhancer(enhancerChain);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin_client_id")//配置client_id
                .secret(passwordEncoder.encode("admin_client_secret"))//配置client_secret
                .accessTokenValiditySeconds(3600)//配置访问token的有效期
                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
                .scopes("all")//配置申请的权限范围
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")//配置grant_type，表示授权类型
                .and()
                .withClient("user_client_id")//配置client_id
                .secret(passwordEncoder.encode("user_client_secret"))//配置client_secret
                .accessTokenValiditySeconds(3600)//配置访问token的有效期
                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
                .scopes("all")//配置申请的权限范围
                .authorizedGrantTypes("authorization_code", "password", "refresh_token");

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("permitAll()");
        security.tokenKeyAccess("permitAll()");
    }

}
