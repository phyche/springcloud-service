package com.example.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springcloud.module.Organization;
import com.example.springcloud.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"com.example.springcloud.service"})
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/hello")
    public String hello() {
        return "welcome to spring cloud hystrix service";
    }

    @RequestMapping("/save")
    public String save() {
        Organization organization = new Organization();
        organization.setOrgId("1000");
        organization.setOrgName("test2");
        redisService.saveOrg(organization);
        return "save success";
    }

    @RequestMapping("/delete")
    public String delete() {
        redisService.deleteOrgByOrgId("1000");
        return "delete success";
    }

    @RequestMapping("/query")
    public String query() {
        Organization organization = redisService.queryOrgByOrgId("1000");
        return JSONObject.toJSONString(organization);
    }
}
