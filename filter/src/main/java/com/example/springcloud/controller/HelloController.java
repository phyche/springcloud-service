package com.example.springcloud.controller;

import com.netflix.zuul.context.RequestContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.example.springcloud.util.FilterUtil.CORRELATION_ID;

/**
 * Spring Cloud和Zuul进行服务路由
 * 消费者的请求地址：http://localhost:1111/api-zuul/hello
 * 实际请求地址：http://localhost:2222/hello
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        //RequestContext context = RequestContext.getCurrentContext();
        String correlation_id = request.getHeader(CORRELATION_ID);
        System.out.println("关联id：" + correlation_id);
        return "welcome to spring cloud zuul service";
    }

}
