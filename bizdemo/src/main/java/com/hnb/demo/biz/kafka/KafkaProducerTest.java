package com.hnb.demo.biz.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class KafkaProducerTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.75.4.31:9093");
//        props.put("acks", "all");
//        props.put("retries", 0);
//        props.put("batch.size", 16384);
//        props.put("linger.ms", 1);
//        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            System.out.println("Send:" + i);
            String data = in.nextLine();
            producer.send(new ProducerRecord<String, String>("topic-test", Integer.toString(i), data));
        }
        producer.close();

    }
}
