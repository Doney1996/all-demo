package com.doney.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.Arrays;
import java.util.List;

public class Consumer {

    public static void main(String[] args) throws InterruptedException, MQClientException {

        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("doney");
         
        // Specify name server addresses.
        consumer.setNamesrvAddr("localhost:9876");
        
        // Subscribe one more  topics to consume.
        consumer.subscribe("TopicTest", "*");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener((List<MessageExt> msgs,
                                          ConsumeConcurrentlyContext context)->{
            msgs.forEach(ele->{
                String msgId = ele.getMsgId();
                String s = new String(ele.getBody());
                int reconsumeTimes = ele.getReconsumeTimes();
                System.out.printf(" msgid:%s  重试次数:%d body[%s] \n",msgId,reconsumeTimes,s);
            });
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}