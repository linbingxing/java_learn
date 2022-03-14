package org.learn.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;
import java.util.Set;

public class MyPullConsumer {

    public static volatile boolean running = true;

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
//        /*
//         * Instantiate with specified consumer group name.
//         */
//        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer("MyPullConsumer");
//
//        /*
//         * Specify name server addresses.
//         * <p/>
//         *
//         * Alternatively, you may specify name server addresses via exporting environmental variable: NAMESRV_ADDR
//         * <pre>
//         * {@code
//         * consumer.setNamesrvAddr("name-server1-ip:9876;name-server2-ip:9876");
//         * }
//         * </pre>
//         */
//        consumer.setNamesrvAddr("192.168.56.11:9876");
//        /*
//         * Specify where to start in case the specified consumer group is a brand new one.
//         */
////        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//        /*
//         *  Launch the consumer instance.
//         */
//        consumer.start();
//
//        final Set<MessageQueue> messageQueues = consumer.fetchSubscribeMessageQueues("TopicTest");
//        for (MessageQueue messageQueue : messageQueues) {
//            // 第一个参数是MessageQueue对象，代表了当前主题的一个消息队列
//            //第二个参数是一个表达式，对接收的消息按照tag进行过滤
//            //支持"tag1 || tag2 || tag3"或者 "*"类型的写法；null或者"*"表示不对 消息进行tag过滤
//            //第三个参数是消息的偏移量，从这里开始消费
//            //第四个参数表示每次最多拉取多少条消息
//            final PullResult result = consumer.pull(messageQueue, "*", 0, 10);
//        }
//        System.out.printf("Consumer Started.%n");


        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("lite_pull_consumer_test");
        litePullConsumer.setNamesrvAddr("192.168.56.11:9876");
        litePullConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        litePullConsumer.subscribe("BatchTest", "*");
        litePullConsumer.start();
        try {
            while (running) {
                List<MessageExt> messageExts = litePullConsumer.poll();
                System.out.printf("%s%n", messageExts);
            }
        } finally {
            litePullConsumer.shutdown();
        }
    }
}
