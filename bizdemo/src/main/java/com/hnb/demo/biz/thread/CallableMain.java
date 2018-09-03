package com.hnb.demo.biz.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableMain implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        return Long.valueOf(12);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask future = new FutureTask(new CallableMain());
        Thread thread = new Thread(future);
        thread.start();
        System.out.printf(String.valueOf(future.get()));
    }
}
