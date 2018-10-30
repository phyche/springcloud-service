package com.example.springcloud;

import com.alibaba.fastjson.JSONObject;
import com.example.springcloud.module.OrganizationChangeModule;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaServer //此服务即是eureka注册中心又是服务的提供者
@EnableEurekaClient
@EnableCircuitBreaker//如果没有则hystrix断路器不会处于活动状态
public class HystrixApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}
}
