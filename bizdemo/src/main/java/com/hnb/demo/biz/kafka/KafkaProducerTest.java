package com.hnb.demo.biz.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class KafkaProducerTest {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
//        props.put("bootstrap.servers", "dev-node1:9092,dev-node2ded:9092,dev-node3:9092");
        props.put("bootstrap.servers", "kafka:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        try {
            File file = new File("C:\\Users\\hnbcao\\Documents\\Tencent Files\\61579533\\FileRecv\\1.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String data = reader.readLine();
            while (data != null) {
                producer.send(new ProducerRecord("iron1", data));
                Thread.sleep(10000);
            }
        } catch (IOException e) {

        }
//        Boolean close = false;
//        while (!close) {
//            senMessage(producer);
//        }
        producer.close();
        HashMap<String,String> map = new HashMap<String,String>();
        map.put(null,null);
    }

    private static void senMessage(Producer<String, String> producer) throws InterruptedException {
        String tempString;
        for (int i = 1; i <= 10; i++) {
            tempString = TableDataCreator.createListString(1);
            producer.send(new ProducerRecord("rick", tempString));
            Thread.sleep(10000);
            System.out.println(tempString);
        }

    }
}
