//package com.example.springcloud;
//
//import com.example.springcloud.module.OrganizationChangeModule;
//import org.apache.log4j.Logger;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//
///**
// * 消息的消费者
// */
////@SpringBootApplication
//@EnableBinding(Sink.class)
//public class MessageConsumerApplication {
//
//    @StreamListener(Sink.INPUT)
//    public void loggerSink(OrganizationChangeModule changeModule) {
//        System.out.println("receive an event for orgznization id:" + changeModule.getOrgId());
//    }
//
//    /*public static void main(String[] args) {
//        SpringApplication.run(MessageConsumerApplication.class, args);
//    }*/
//}
