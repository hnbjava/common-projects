package com.hnb.demo.biz.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class KafkaProducerTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.75.4.9:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        Boolean close = false;
        while (!close) {
            senMessage(producer);
        }
        producer.close();

    }

    private static void senMessage(Producer<String, String> producer) {
        String tempString;
        for (int i = 1; i <= 10; i++) {
            if (i > 5) {
                tempString = TableDataCreator.createListString(i + 5);
            } else {
                tempString = TableDataCreator.createListString(i);
            }
            producer.send(new ProducerRecord("rick", tempString));
            System.out.println(tempString);
        }

    }
}
