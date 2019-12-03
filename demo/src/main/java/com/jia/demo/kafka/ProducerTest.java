package com.jia.demo.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProducerTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "zoo-1:9092,zoo-2:9092,zoo-3:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        /**
         * acks=0 设置成0表示producer完全不理睬leader broker端的处理结果,立即发送下一条消息
         * 在这种情况下producer.send的回调也就完全失去了作用
         * acks=all或者-1:表示当发送消息时,leader broker不仅会将消息写入本地日志,同时 还会等待ISR中所有其他副本都成功写入他们各自的本地日志后,才返回给producer
         * acks=1 :是折中方案 即leader broker消息写入本地日志后 就返回给producer结果
         */
        props.put("acks", "-1");
        props.put("retries", 3);
        /**
         * 重要参数:producer会发将发往同一分区的多条消息封装进一个batch中,
         * 当batch满了的时候,producer会发送,也可能batch没满时也会发送该batch
         */
        props.put("batch.size", 323840);
        /**
         * linger.ms参数是控制消息发送延时行为的,默认值0,
         * 表示消息需要立即被发送,无需关心batch被填满
         * 不过这会拉低producer的吞吐量
         */
        props.put("linger.ms", 10);
        /**
         * producer端用于缓存消息的缓冲区大小
         */
        props.put("buffer.memory", 33554432);
        // props.put("partitioner.class", "com.jia.demo.kafka.CustomPartition");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 100; i++) {
            /**
             * kafka会尽量保证相同的key落入到同一个分区上,如果没有指定key值则会均匀的落入到不同分区上
             */
            ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", String.valueOf(i));
            try {
                //RecordMetadata metadata = producer.send(record).get();
                Future<RecordMetadata> recordMetadataFuture = producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        //todo
                    }
                });
                String result = "值 [" + record.value() + "] has been sent to partition " + recordMetadataFuture.get().partition();
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        producer.close();
    }
}
