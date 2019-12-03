package com.jia.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaConsumerTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        String topic = "test-topic";
        Properties props = new Properties();
        props.put("bootstrap.servers", "zoo-1:9092,zoo-2:9092,zoo-3:9092"); //这里的localhost可以改成机器名或ip
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "0");
        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset", "earliest");
        props.put("max.poll.records",1000);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
        try {
            while (true) {
                /**
                 * 这里的1000是一个超时时间设定,通常情况下如果consumer拿到足够多的数据,那么它可以立即从该方法返回,否则
                 * consumer会处于阻塞状态.1000表示 及时没有那么多的数据 consumer最多也不要等待超过1s.
                 * 这种设置提供了了一种可能:就在消费之余可以做一些其他事情
                 */
                ConsumerRecords<String, String> records = consumer.poll(3000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record);
                }
            }
        } finally {
            consumer.close();
        }
    }
}
