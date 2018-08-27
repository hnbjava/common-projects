package com.hnb.demo.biz.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * @author xiaolu
 * @date 2018/8/16 下午3:10
 */
public class SocketChannelMain {
    public static void main(String[] args) throws IOException {
        WritableByteChannel channel = Channels.newChannel(System.out);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String host = "localhost";
        int port = 1234;
        InetSocketAddress address = new InetSocketAddress(host, port);
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(address);
        while (true) {
            if (sc.isConnected()) {
                sc.read(buffer);
                break;
            }
        }
        while (!sc.finishConnect()) {
            sc.close();
        }
    }
}
