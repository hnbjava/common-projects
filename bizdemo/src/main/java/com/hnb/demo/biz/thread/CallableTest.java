package com.hnb.demo.biz.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xiaolu
 * @date 2018/8/27 下午11:39
 */
public class CallableTest {
    static class CallableImpl implements Callable<Integer> {
        int a = 0;

        public CallableImpl(int a) {
            this.a = a;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(a * 1000);
            return a++;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<FutureTask> taskList = new ArrayList<FutureTask>();
        for (int i = 0; i < 10; i++) {
            FutureTask task = new FutureTask(new CallableImpl(i));
            taskList.add(task);
        }

        for (FutureTask task : taskList) {
            new Thread(task).start();
        }

        System.out.println("wait.....");

        for (FutureTask task : taskList) {
            System.out.println(task.get());
        }

    }
}
