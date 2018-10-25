package com.example.springcloud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@EnableEurekaServer //此服务即是eureka注册中心又是服务的提供者
@EnableEurekaClient//切换了cloud的版本，所以暂时屏蔽
@EnableCircuitBreaker//如果没有则hystrix断路器不会处于活动状态
public class SpringcloudApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudApplication.class, args);
	}

}
