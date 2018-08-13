package com.hnb.demo.biz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaolu
 * @date 2018/8/13 上午9:12
 */
public class ReflectMain {
    public void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void staticTarget(int i) {
//        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        v0();
        //        v1();
        v2();
        v3();
        v4();
    }

    private static void v0() {
        long current = System.currentTimeMillis();

        for (int i = 0; i < 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            staticTarget(128);
        }
    }

    private static void v4() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> klass = Class.forName(ReflectMain.class.getName());

        Method method = klass.getMethod("staticTarget", int.class);
        //关闭权限
        method.setAccessible(true);
        long current = System.currentTimeMillis();

        for (int i = 0; i < 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, 128);
        }
    }

    private static void v3() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> klass = Class.forName(ReflectMain.class.getName());

        Method method = klass.getMethod("staticTarget", int.class);

        long current = System.currentTimeMillis();

        Object[] arg = new Object[1];
        arg[0] = 128;

        for (int i = 0; i < 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, arg);
        }
    }

    private static void v2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> klass = Class.forName(ReflectMain.class.getName());

        Method method = klass.getMethod("staticTarget", int.class);

        long current = System.currentTimeMillis();

        for (int i = 0; i < 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, 128);
        }
    }

    private static void v1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        //获取CLASS
        Class<?> klass = Class.forName(ReflectMain.class.getName());

        //获取构造器
        Constructor cons = klass.getConstructor();

        //获取对象实例
        ReflectMain reflectMain = (ReflectMain) cons.newInstance();

        //获取方法实例
        Method method = klass.getMethod("target", int.class);

        for (int i = 0; i < 20; i++) {
            method.invoke(reflectMain, i);
        }
    }
}
