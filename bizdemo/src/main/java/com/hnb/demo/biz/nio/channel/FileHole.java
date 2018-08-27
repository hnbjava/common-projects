package com.hnb.demo.biz.nio.channel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author xiaolu
 * @date 2018/8/16 上午11:30
 */
public class FileHole {
    public static void main(String[] args) throws IOException {
        File temp = new File("holy.txt");
        RandomAccessFile file = new RandomAccessFile(temp, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        putData(0, byteBuffer, channel);
        putData(5000000, byteBuffer, channel);
        putData(50000, byteBuffer, channel);
        System.out.println("Wrote temp file '" + temp.getPath() + "',size=" + channel.size());
    }

    private static void putData(int position, ByteBuffer buffer, FileChannel channel) throws IOException {
        String string = "*<-- location " + position;
        buffer.clear();
        buffer.put(string.getBytes("UTF-8"));
        buffer.flip();
        channel.position(position);
        channel.write(buffer);
    }
}
