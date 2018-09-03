package com.hnb.demo.biz.rpc;

import com.hnb.demo.biz.rpc.client.RPCClient;
import com.hnb.demo.biz.rpc.service.HelloService;

import java.net.InetSocketAddress;

/**
 * @author xiaolu
 * @date 2018/8/14 上午11:30
 */
public class ClientMain {
    public static void main(String[] args) {
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("5678"));
        System.out.println(service.sayHi("56778"));
    }
}
