package com.example.springcloud.controller;

import com.example.springcloud.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication(scanBasePackages = {"com.example.springcloud.service"})
public class HelloController {

    @Autowired
    private LicenseService licenseService;

    @RequestMapping("/hello")
    public String hello() {
        return "welcome to spring cloud service";
    }

    @RequestMapping("/license")
    public String license() {
        List licenseList = licenseService.getLicensesByOrg("1");
        return licenseList.toString();
    }
}
