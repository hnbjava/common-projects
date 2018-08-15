package com.hnb.demo.biz.rpc.service.impl;

import com.hnb.demo.biz.rpc.service.HelloService;

/**
 * @author xiaolu
 * @date 2018/8/14 上午10:55
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String userName) {
        return userName + " sayHi";
    }
}
