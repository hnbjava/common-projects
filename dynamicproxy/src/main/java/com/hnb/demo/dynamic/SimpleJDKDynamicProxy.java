package com.hnb.demo.dynamic;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaolu
 * @date 2018/7/31 下午4:43
 */
public class SimpleJDKDynamicProxy {
    static interface IService {
        public void sayHello();
    }

    static class RealService implements IService {

        @Override
        public void sayHello() {
            System.out.println("RealService:Hello");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {

        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
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

    public static void main(String[] args) {
        IService realService = new RealService();
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                realService.getClass().getInterfaces(),
                new SimpleInvocationHandler(realService));
        proxyService.sayHello();
    }
}
