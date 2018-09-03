package com.hnb.demo.biz.thread;

/**
 * @author xiaolu
 * @date 2018/8/30 上午10:07
 */
public class SyncThread {
    private volatile static int a;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    app();
                }
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    adel();
                }
            }
        });
        thread1.start();
    }

    static synchronized int app() {
        System.out.println("BEGINa++:" + a);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
        System.out.println("ENDa++:" + a);
        return a;
    }

    static synchronized int adel(){
        System.out.println("BEGINa--:" + a);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a--;
        System.out.println("ENDa--:" + a);
        return a;
    }
}
