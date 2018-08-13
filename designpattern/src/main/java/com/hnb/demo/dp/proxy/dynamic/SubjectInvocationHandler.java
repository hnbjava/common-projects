package com.hnb.demo.dp.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xiaolu
 * @date 2018/8/13 下午5:43
 */
public class SubjectInvocationHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object realObj;

    public SubjectInvocationHandler(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("entering " + method.getName());

        Object result = method.invoke(realObj, args);

        System.out.println("leaving " + method.getName());

        return result;
    }
}
