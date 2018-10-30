package com.example.springcloud;

import com.example.springcloud.module.OrganizationChangeModule;
import org.apache.log4j.Logger;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {

    private Source source;
    private static final Logger logger = Logger.getLogger(SimpleSourceBean.class);

    public SimpleSourceBean(Source source) {
        this.source = source;
    }

    public void publishOrgChange(String action,String orgId) {
        System.out.println("Sending kafka message "+ action+ " for Organization id: "+orgId);

        //要发布消息的实体类
        OrganizationChangeModule change = new OrganizationChangeModule(
                OrganizationChangeModule.class.getTypeName(),
                action,
                orgId,
                "tmx-correlation-id");

        //当准备发布消息时，使用Source类中定义的通道的send()方法
        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
