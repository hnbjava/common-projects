package com.hnb.demo.biz.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author xiaolu
 * @date 2018/8/27 上午9:35
 */
public class FileReadChannel {
    public static void main(String[] args) throws IOException {
        WritableByteChannel dest = Channels.newChannel(System.out);
        ReadableByteChannel source = Channels.newChannel(new FileInputStream("ssss.txt"));
//        channelCopy(source, dest);
        channelCopyEx(source, dest);
        source.close();
        dest.close();
    }

    private static void channelCopyEx(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (-1 != src.read(buffer)) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                dest.write(buffer);

            }
            buffer.clear();
        }
    }

    private static void channelCopy(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(buffer) != -1) {
            buffer.flip();
            dest.write(buffer);
            //buffer压缩，释放缓冲区已读取数据
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            dest.write(buffer);
        }
    }
}
