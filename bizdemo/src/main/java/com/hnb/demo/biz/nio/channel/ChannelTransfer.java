package com.hnb.demo.biz.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author xiaolu
 * @date 2018/8/16 下午2:24
 */
public class ChannelTransfer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){

        }
        String filePath = "/Users/xiaolu/Documents/GitHub/hannibal/bizdemo/target/classes/text.txt";
        catFiles(Channels.newChannel(System.out),filePath);
    }

    private static void catFiles(WritableByteChannel writableByteChannel, String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileChannel channel = fis.getChannel();
        channel.transferTo(0,channel.size(),writableByteChannel);
        channel.close();
        fis.close();
    }
}
