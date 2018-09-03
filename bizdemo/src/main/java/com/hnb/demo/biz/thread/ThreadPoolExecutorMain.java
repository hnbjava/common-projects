package com.hnb.demo.biz.thread;

import java.util.concurrent.*;

/**
 * @author xiaolu
 * @date 2018/8/15 上午10:24
 */
public class ThreadPoolExecutorMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(11);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5, 60, TimeUnit.SECONDS, queue,handler);
//        for (int i = 0; i < 16; i++) {
//            threadPool.execute(new Thread(new ThreadPoolTest(i), "Thread".concat(i + "")));
//            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
//            if (queue.size() > 0) {
//                System.out.println("----------------队列中阻塞的线程数" + queue.size());
//            }
//        }
        Callable task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(12);
                return 12;
            }
        };
        Future a = threadPool.submit(task);
        System.out.println(a.get());

        threadPool.shutdown();
    }

    private static class ThreadPoolTest implements Runnable {
        public ThreadPoolTest(int a) {
            this.a = a;
        }

        int a = 10;
        int c = 10;

        @Override
        public void run() {
            while (c > 5) {
                System.out.println(Thread.currentThread().getName() + " is running .." + a);


                try {
                    Thread.sleep(3000);
                    c--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
