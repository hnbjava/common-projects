package com.hnb.demo.biz.thread;

/**
 * @author xiaolu
 * @date 2018/8/2 上午10:46
 */
public class ThreadMain {

    public static void main(String[] args) {
        testSynchronizedThread();
        testNotSynchronizedThread();
    }

    private static void testSynchronizedThread() {
        Count count = new Count();
        Thread thread1 = new SynchronizedThread(count);
        Thread thread2 = new SynchronizedThread(count);
        Thread thread3 = new SynchronizedThread(count);
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void testNotSynchronizedThread() {
        Count count = new Count();
        Thread thread1 = new SynchronizedNotThread(count);
        Thread thread2 = new SynchronizedNotThread(count);
        Thread thread3 = new SynchronizedNotThread(count);
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread3.setName("thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class SynchronizedThread extends Thread {

        private Count count;

        public SynchronizedThread(Count count) {
            this.count = count;
        }

        public Count getCount() {
            return count;
        }

        public void setCount(Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(count.addSynchronizedCount(this.getName()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class SynchronizedNotThread extends Thread {

        private Count count;

        public SynchronizedNotThread(Count count) {
            this.count = count;
        }

        public Count getCount() {
            return count;
        }

        public void setCount(Count count) {
            this.count = count;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(count.addCount(this.getName()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class HashTableThread extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    static class Count {

        int value = 0;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private String addCount(String name) {
            ++value;
            String res = name + ":" + value;
            return res;
        }

        private synchronized String addSynchronizedCount(String name) {
            ++value;
            String res = name + ":" + value;
            return res;
        }
    }
}
