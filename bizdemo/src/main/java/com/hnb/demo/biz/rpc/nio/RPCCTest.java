package com.hnb.demo.biz.rpc.nio;

import com.hnb.demo.biz.rpc.nio.core.RPCClient;
import com.hnb.demo.biz.rpc.service.HelloService;

/**
 * @author xiaolu
 * @date 2018/8/14 下午3:32
 */
public class RPCCTest {
    public static void main(String[] args) {
        RPCClient client = RPCClient.getInstance();
        client.init("127.0.01");
        HelloService sayHello = (HelloService) client.getRemoteProxy(HelloService.class);
        System.out.println("client:" + sayHello.sayHi("ninini"));
        sayHello.sayHi("i am come from client");
    }
}
