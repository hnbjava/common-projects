package com.hnb.demo.biz.rpc.client;

import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;

/**
 * @author xiaolu
 * @date 2018/8/14 上午11:21
 */
public class RPCClient<T> {
    public static <T> T getRemoteProxyObj(final Class<?> serviceInterface, final InetSocketAddress addr) {
        // 1.将本地的接口调用转换成JDK的动态代理，在动态代理中实现接口的远程调用
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface},
                new RPCInvocationHandler(serviceInterface, addr));
    }
}
