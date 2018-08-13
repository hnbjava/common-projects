package com.hnb.demo.dp.proxy.dynamic.subject;

/**
 * @author xiaolu
 * @date 2018/8/13 下午5:42
 */
public class RealSubject implements Subject {
    @Override
    public void doSomeThing(String str) {
        System.out.println("RealSubject:" + str);
    }
}
