package com.hnb.demo.biz.rpc.nio;

import com.hnb.demo.biz.rpc.nio.core.RPCServer;
import com.hnb.demo.biz.rpc.service.impl.HelloServiceImpl;

/**
 * @author xiaolu
 * @date 2018/8/14 下午3:33
 */
public class RPCSTest {
    public static void main(String[] args) {
        RPCServer server = RPCServer.getInstance();
        server.addClass(new HelloServiceImpl());
        server.start();
    }
}
