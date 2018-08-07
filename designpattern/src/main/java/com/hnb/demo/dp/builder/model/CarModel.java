package com.hnb.demo.dp.builder.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaolu
 * @date 2018/8/7 下午4:30
 */
public abstract class CarModel {

    /**
     * 汽车启动顺序
     */
    private List<String> sequence = new ArrayList<String>();

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
    final public void run() {
        for (String step : sequence) {
            switch (step) {
                case "start":
                    this.start();
                    break;
                case "engineBoom":
                    this.engineBoom();
                    break;
                case "alarm":
                    this.alarm();
                    break;
                case "stop":
                    this.stop();
                    break;
                default:
                    break;
            }
        }
    }

    public List<String> getSequence() {
        return sequence;
    }

    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
}
