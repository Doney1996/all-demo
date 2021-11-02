package com.doney.rocketmq.orderMsg;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class OrderedProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new DefaultMQProducer("example_group_name");
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        //假设这里是多个场景，需要按照场景顺序消费
        //如创建 初始化 减库存 支付  发货 结束
        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        // 这里产生10个订单
        for (int orderId = 0; orderId < 10; orderId++) {
            for (int j = 0; j < 5; j++) {
                //Create a message instance, specifying topic, tag and message body.
                Message msg = new Message("TopicOrder", tags[j], "KEY" + j,
                        ("OrderId: " + orderId + " Step: " + tags[j]).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, orderId);
                System.out.printf("%s%n", sendResult);
            }
        }
        //server shutdown
        producer.shutdown();
    }
}