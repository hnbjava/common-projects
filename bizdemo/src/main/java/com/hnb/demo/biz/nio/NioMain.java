package com.hnb.demo.biz.nio;

import java.nio.channels.Channel;
import java.nio.channels.Channels;

/**
 * @author xiaolu
 * @date 2018/8/15 上午11:57
 */
public class NioMain {
    public static void main(String[] args) {
        Channel in = Channels.newChannel(System.in);
        Channel out = Channels.newChannel(System.out);
//        Byte
        while (true){

        }
    }
}
