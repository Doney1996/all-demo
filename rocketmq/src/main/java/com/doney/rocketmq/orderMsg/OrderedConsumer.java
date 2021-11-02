package com.doney.rocketmq.orderMsg;

import org.apache.commons.lang3.RandomUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderedConsumer {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("example_group_name");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("TopicOrder", "TagA || TagB || TagC || TagD || TagE" );

        consumer.registerMessageListener(new MessageListenerOrderly() {

            final AtomicLong consumeTimes = new AtomicLong(0);
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs,
                                                       ConsumeOrderlyContext context) {
                System.out.println("ConsumeTimes : " + consumeTimes.get());
                this.consumeTimes.incrementAndGet();
                if ((this.consumeTimes.get() % 2) == 0) {
                    for (MessageExt msg : msgs) {
                        String msgBody = new String(msg.getBody());
                        System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgBody + "%n");
                    }
                    return ConsumeOrderlyStatus.SUCCESS;
                }else {
                    context.setSuspendCurrentQueueTimeMillis(RandomUtils.nextInt(50,100));
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }
            }
        });

        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}