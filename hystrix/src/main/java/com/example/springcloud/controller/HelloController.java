package com.example.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springcloud.service.LicenseService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication(scanBasePackages = {"com.example.springcloud.service","com.example.springcloud.dao"})
@MapperScan("com.example.springcloud.dao")
public class HelloController {

    @Autowired
    private LicenseService licenseService;

    @RequestMapping("/hello")
    public String hello() {
        return "welcome to spring cloud hystrix service";
    }

    @RequestMapping("/license")
    public String license() {
        List licenseList = licenseService.getLicensesByOrg("1");
        return JSONObject.toJSONString(licenseList);
    }
}
