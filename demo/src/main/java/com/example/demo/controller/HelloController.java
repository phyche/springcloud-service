package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello() {
        return "welcome to spring cloud service";
    }

}
