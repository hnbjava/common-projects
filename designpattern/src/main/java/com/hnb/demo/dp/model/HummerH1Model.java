package com.hnb.demo.dp.model;

/**
 * @author xiaolu
 * @date 2018/8/7 下午4:03
 */
public class HummerH1Model extends AbstractHummerModel {

    public HummerH1Model() {
        System.out.println("constructor");
    }

    @Override
    public void start() {
        System.out.println("H1:start");
    }

    @Override
    public void stop() {
        System.out.println("H1:stop");
    }

    @Override
    public void alarm() {
        System.out.println("H1:alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("H1:engineBoom");
    }
}
