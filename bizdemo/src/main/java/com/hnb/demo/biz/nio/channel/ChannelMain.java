package com.hnb.demo.biz.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author xiaolu
 * @date 2018/8/15 下午2:54
 */
public class ChannelMain {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        RandomAccessFile file = new RandomAccessFile("/Users/xiaolu/Documents/GitHub/hannibal/bizdemo/target/classes/text.txt","r");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");
        channel.close();
    }
}
