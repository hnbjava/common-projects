package com.hnb.demo.biz.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author xiaolu
 * @date 2018/8/16 下午2:44
 */
public class ServerSocketChannelMain {

    public static final String GREETING = "dsadasfasdasasdas";

    public static void main(String[] args) throws IOException, InterruptedException {

        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ServerSocket serverSocket = ssc.socket();
        serverSocket.bind(new InetSocketAddress(1234));
        ssc.configureBlocking(false);
        while (true){
            System.out.println("Waiting for connections");
            SocketChannel sc = ssc.accept();
            if(sc==null){
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from:"+sc.socket().getRemoteSocketAddress());
                buffer.rewind();
                sc.write(buffer);
                sc.close();
            }
        }

    }
}
