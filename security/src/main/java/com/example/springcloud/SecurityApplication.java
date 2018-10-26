package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer//告诉spring cloud该服务将作为OAuth2服务
public class SecurityApplication {

    @RequestMapping("/user")
    public Map<String,Object> user(OAuth2Authentication user) {
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("user",user.getUserAuthentication().getPrincipal());
        userInfo.put("authorites",user.getUserAuthentication().getAuthorities());
        return userInfo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}