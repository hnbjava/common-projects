package com.hnb.demo.biz.comparator;

import java.util.*;

/**
 * @author xiaolu
 * @date 2018/7/31 下午4:42
 */
public class TestComparator {
    public static void main(String[] args) {
        Apple apple0 = new Apple(11);
        Apple apple1 = new Apple(12);
        System.out.println(apple0.compare(apple1, apple0));
        List<Apple> apps = new ArrayList<Apple>();
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                apps.add( new Apple(i));
            } else {
                apps.add(new Apple(100-i));
            }
        }
        Collections.sort(apps,new Apple(12));
        for (Object apple:apps) {
            System.out.println(((Apple)apple).getSize());
        }
    }
}
