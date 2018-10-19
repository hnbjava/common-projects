package com.hnb.demo.biz.thread;

import java.util.Vector;

public class VectorTest {
    public static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            }).start();

            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println(vector.get(i));
                }
            }).start();

            while (Thread.activeCount() > 20) ;
        }
    }
}
