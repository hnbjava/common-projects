package com.hnb.demo.dp.builder.builder;

import com.hnb.demo.dp.builder.model.CarModel;

import java.util.List;

/**
 * @author xiaolu
 * @date 2018/8/7 下午5:35
 */
public abstract class CarBuilder {
    /**
     * 设置顺序
     * @param sequence
     */
    public abstract void setSequence(List<String> sequence);

    /**
     * 获取模型
     * @return
     */
    public abstract CarModel getCarModel();
}
