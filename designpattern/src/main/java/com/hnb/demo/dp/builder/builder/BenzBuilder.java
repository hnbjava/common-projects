package com.hnb.demo.dp.builder.builder;

import com.hnb.demo.dp.builder.model.BenzModel;
import com.hnb.demo.dp.builder.model.CarModel;

import java.util.List;

/**
 * @author xiaolu
 * @date 2018/8/7 下午5:38
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benzModel;

    public BenzBuilder() {
        this.benzModel = new BenzModel();
    }

    @Override
    public void setSequence(List<String> sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzModel;
    }
}
