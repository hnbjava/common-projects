package com.hnb.demo.biz.list;

import com.hnb.demo.biz.comparator.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaolu
 * @date 2018/8/23 下午5:57
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Apple apple = new Apple(0);
        List<Apple> list = new ArrayList<Apple>();
        Thread.sleep(10000);
        for (int i = 0; i < 10000000; i++) {
            apple = new Apple(i);
            list.add(apple);
        }
        long begin = System.currentTimeMillis();
        list.indexOf(apple);
        long end = System.currentTimeMillis();
        System.out.println(begin);
        System.out.println(end);
        System.out.println(begin - end);
    }
}
