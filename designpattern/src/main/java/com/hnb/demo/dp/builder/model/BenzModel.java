package com.hnb.demo.dp.builder.model;

/**
 * @author xiaolu
 * @date 2018/8/7 下午5:10
 */
public class BenzModel extends CarModel {
    @Override
    public void start() {
        System.out.println("Benz:start");
    }

    @Override
    public void stop() {
        System.out.println("Benz:stop");
    }

    @Override
    public void alarm() {
        System.out.println("Benz:alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("Benz:engineBoom");
    }
}
