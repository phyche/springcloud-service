package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
@EnableBinding(Source.class)//将应用程序绑定到消息代理
public class StreamApplication {

	/*@Bean
	public Filter userContextFilter() {
		UserContextFilter userContextFilter = new usercon
	}*/
	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}
}
