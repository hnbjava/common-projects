package com.hnb.demo.biz.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class KafkaConsumerTest {
    Logger logger = LoggerFactory.getLogger(KafkaConsumerTest.class);

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "zqnode4.segma.tech:9092,zqnode5.segma.tech:9092,zqnode6.segma.tech:9092");
        props.put("group.id", "rick");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        System.out.println("BEGIN");
        //用于跟踪偏移量的map
        final Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
        consumer.subscribe(Arrays.asList("rolling_schedule"), new ConsumerRebalanceListener() {
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
        int index = 1;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            File file = new File("C:\\Users\\hnbcao\\Desktop\\output\\data-" + index++);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (ConsumerRecord record : records) {
                System.out.printf("offset = %d, value = %s%n", record.offset(), record.value());
                writer.write(String.valueOf(record.value()));
            }
            writer.close();
        }
    }
}
