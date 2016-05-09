package com.myf.weixin.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by myf on 2016/5/9.
 */
@Component("RabbitUtil")
public class RabbitUtil {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendData(String queue,Object obj){
        rabbitTemplate.convertAndSend(queue,obj);
    }

    public String receiveData(String queue){
        Message msg = rabbitTemplate.receive(queue);
        return new String(msg.getBody());
    }
}
