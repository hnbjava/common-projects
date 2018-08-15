package com.hnb.demo.biz.rpc;

import com.hnb.demo.biz.rpc.client.RPCClient;
import com.hnb.demo.biz.rpc.server.Server;
import com.hnb.demo.biz.rpc.server.impl.ServiceCenter;
import com.hnb.demo.biz.rpc.service.HelloService;
import com.hnb.demo.biz.rpc.service.impl.HelloServiceImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author xiaolu
 * @date 2018/8/14 上午11:28
 */
public class TestMain {

    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}
