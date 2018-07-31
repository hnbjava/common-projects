package com.hnb.demo.dp.factory.entity;

/**
 * @author xiaolu
 * @date 2018/7/31 上午9:18
 */
public class BlackHuman implements Human {
    private String color;
    private String language;

    public BlackHuman() {
        this.color = "BLACK";
        this.language = "ENGLISH";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String talk() {
        return this.language;
    }
}
