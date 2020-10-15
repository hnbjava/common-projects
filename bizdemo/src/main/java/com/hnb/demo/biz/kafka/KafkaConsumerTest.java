package com.hnb.demo.biz.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class KafkaConsumerTest {
    Logger logger = LoggerFactory.getLogger(KafkaConsumerTest.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.75.4.9:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        System.out.println("BEGIN");
        //用于跟踪偏移量的map
        Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
        consumer.subscribe(Arrays.asList("topic-test"), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                System.out.println("BEGIN1");
                consumer.commitSync(currentOffsets);
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
                System.out.println("BEGIN2");
                //将偏移设置到最开始
                consumer.seekToBeginning(collection);
            }
        });
        System.out.println("BEGIN3");
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord record : records) {
                System.out.printf("offset = %d, value = %s%n", record.offset(),  record.value());
            }
        }
    }
}
