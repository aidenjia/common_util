package com.jia.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class CustomerAscyTest {
    public static void main(String[] args) {
        String topic = "test-topic";
        Properties props = new Properties();
        props.put("bootstrap.servers", "zoo-1:9092,zoo-2:9092,zoo-3:9092"); //这里的localhost可以改成机器名或ip
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "0");
        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset", "earliest");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList(topic));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record);
                }
                consumer.commitAsync();

            }
        } finally {
            consumer.close();
        }
    }
}
