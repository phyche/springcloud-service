package com.example.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springcloud.module.Organization;
import com.example.springcloud.service.OrganizationService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication(scanBasePackages = {"com.example.springcloud.service","com.example.springcloud.dao"})
@MapperScan("com.example.springcloud.dao")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/hello")
    public String hello() {
        return "welcome to spring cloud hystrix service";
    }

    @RequestMapping("/saveOrg")
    public String saveOrg() {
        List organization = organizationService.queryByOrgId("1");
        /*Organization organization = new Organization();
        organization.setOrgName("test");
        organizationService.saveOrg(organization);*/
        return JSONObject.toJSON(organization).toString();
    }
}
