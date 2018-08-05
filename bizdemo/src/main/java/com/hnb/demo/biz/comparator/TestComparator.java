package com.hnb.demo.biz.comparator;

/**
 * @author xiaolu
 * @date 2018/7/31 下午4:42
 */
public class TestComparator {
    public static void main(String[] args) {
        Apple apple0 = new Apple(11);
        Apple apple1 = new Apple(12);
        System.out.println(apple0.compare(apple1, apple0));
    }
}
