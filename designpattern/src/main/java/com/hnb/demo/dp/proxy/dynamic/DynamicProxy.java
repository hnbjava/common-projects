package com.hnb.demo.dp.proxy.dynamic;

import com.hnb.demo.dp.proxy.dynamic.advice.BeforeAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author xiaolu
 * @date 2018/8/13 下午5:41
 */
public class DynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler){
        if(true){
            (new BeforeAdvice()).exec();
        }

        //执行目标，返回结果
        return (T)Proxy.newProxyInstance(loader, interfaces, handler);
    }
}
