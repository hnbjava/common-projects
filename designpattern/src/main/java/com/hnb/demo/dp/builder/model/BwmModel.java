package com.hnb.demo.dp.builder.model;

/**
 * @author xiaolu
 * @date 2018/8/7 下午5:12
 */
public class BwmModel extends CarModel {
    @Override
    public void start() {
        System.out.println("Bwm:start");
    }

    @Override
    public void stop() {
        System.out.println("Bwm:stop");
    }

    @Override
    public void alarm() {
        System.out.println("Bwm:alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("Bwm:engineBoom");
    }
}
