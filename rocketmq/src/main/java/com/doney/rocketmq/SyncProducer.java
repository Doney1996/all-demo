package com.doney.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
            DefaultMQProducer("doney");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 100; i++) {
            extracted(producer, i);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }

    private static void extracted(DefaultMQProducer producer, int i) throws UnsupportedEncodingException, MQClientException, RemotingException, MQBrokerException, InterruptedException {
        //Create a message instance, specifying topic, tag and message body.
        Message msg = new Message("TopicTest" /* Topic */,
            "TagA" /* Tag */,
            ("Hello RocketMQ " +
                    i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
        );
        //Call send message to deliver message to one of brokers.
        SendResult sendResult = producer.send(msg);
        System.out.printf("%s%n", sendResult);
    }
}
