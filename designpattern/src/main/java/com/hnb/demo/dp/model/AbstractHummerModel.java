package com.hnb.demo.dp.model;

/**
 * @author xiaolu
 * @date 2018/8/7 下午3:45
 */
public abstract class AbstractHummerModel {

    /**
     * 启动引擎
     */
    public abstract void start();

    /**
     * 停止引擎
     */
    public abstract void stop();

    /**
     * 鸣笛
     */
    public abstract void alarm();

    /**
     * 引擎声音
     */
    public abstract void engineBoom();

    /**
     * 汽车启动
     */
    public void run(){
        this.start();
        this.engineBoom();
        this.alarm();
        this.stop();
    }
}
