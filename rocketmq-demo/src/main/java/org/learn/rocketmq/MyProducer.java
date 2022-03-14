package org.learn.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class MyProducer {

    public static void main(String[] args) {
        try {
            DefaultMQProducer producer= new DefaultMQProducer("MyProducer");
            // 指定NameServer的地址
            producer.setNamesrvAddr("192.168.56.11:9876");
            producer.start();
            producer.setSendMsgTimeout(600000);
            for (int i = 0; i < 100; i++) {
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
            // 关闭生产者
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
