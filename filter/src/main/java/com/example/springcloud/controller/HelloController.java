package com.example.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring Cloud和Zuul进行服务路由
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "welcome to spring cloud zuul service";
    }

}
