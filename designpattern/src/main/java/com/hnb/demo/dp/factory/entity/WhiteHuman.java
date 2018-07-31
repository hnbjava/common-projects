package com.hnb.demo.dp.factory.entity;

/**
 * @author xiaolu
 * @date 2018/7/31 上午9:18
 */
public class WhiteHuman implements Human {
    private String color;
    private String language;

    public WhiteHuman() {
        this.color = "WHITE";
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
