package com.hnb.demo.biz.thread;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    public static AtomicInteger value = new AtomicInteger(0);

    public static void increase() {
        value.incrementAndGet();
    }

    private final static int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (Thread thread : threads) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < 10000; i++) {

                        increase();
                    }
                }
            });
            thread.start();
        }

        int i = 0;
        while (Thread.activeCount() > 2) {
            Thread.yield();
            i++;
            if (i % 1000 == 0) {
                System.out.println(Thread.activeCount() + ":" + i);
            }
        }

        System.out.println(value);
    }
}
