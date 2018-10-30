package com.example.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用spring 和 OAuth2
 */
@RestController
public class HelloController {

    @RequestMapping("/user")
    public String user(OAuth2Authentication user) {
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("user",user.getUserAuthentication().getPrincipal());
        userInfo.put("authorites",user.getUserAuthentication().getAuthorities());
        return JSONObject.toJSONString(userInfo);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "welcome to spring cloud security service";
    }

}
