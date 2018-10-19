package com.hnb.demo.biz.thread;

import java.util.HashSet;
import java.util.Vector;

public class SyncTest {
    Vector vector = new Vector();
    private Integer a;

    public synchronized int getA() {
        return a;
    }

    public synchronized void setA(int a) throws InterruptedException {
        synchronized (this){
            Thread.sleep(1000);
            this.a = a;
        }

    }

    public static void main(String[] args) {
        SyncTest obj = new SyncTest();
        Thread t1 = new Thread(()->{
            try {
                obj.setA(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        System.out.println(obj.getA());
        obj.vector.addElement(null);
    }
}
