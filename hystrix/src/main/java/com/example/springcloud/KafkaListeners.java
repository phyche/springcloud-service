package com.example.springcloud;

import com.alibaba.fastjson.JSONObject;
import com.example.springcloud.module.OrganizationChangeModule;
import com.example.springcloud.util.JSONUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KafkaListeners {

    @KafkaListener(topics = {"orgChangeTopic"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            //Object message = kafkaMessage.get();
            String message = kafkaMessage.get().toString();
            System.out.println("receive message:" + message);
            message = message.substring(86,message.length());//获取消息体内容
            System.out.println("message body:" + message);
            //转化实体类有问题时，可以转map然后获取信息
            //转化为实体类时必须提供一个无参的构造函数，不然转化不了
            OrganizationChangeModule change = JSONUtil.parse(message,OrganizationChangeModule.class);
            Map map = JSONUtil.parse(message,HashMap.class);//转map，通用
            System.out.println("receive an event for orgznization id: " + change.getOrgId());

            //可以调用redis的服务，对消息进行处理
        }

    }
}
