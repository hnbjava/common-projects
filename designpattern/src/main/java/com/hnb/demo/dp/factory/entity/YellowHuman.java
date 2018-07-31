package com.hnb.demo.dp.factory.entity;

/**
 * @author xiaolu
 * @date 2018/7/31 上午9:18
 */
public class YellowHuman implements Human {
    private String color;
    private String language;

    public YellowHuman() {
        this.color = "YELLOW";
        this.language = "CHINESE";
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
