package com.hnb.demo.dp.builder.builder;

import com.hnb.demo.dp.builder.model.BenzModel;
import com.hnb.demo.dp.builder.model.BwmModel;
import com.hnb.demo.dp.builder.model.CarModel;

import java.util.List;

/**
 * @author xiaolu
 * @date 2018/8/7 下午5:38
 */
public class BwmBuilder extends CarBuilder {

    private BwmModel bwmModel;

    public BwmBuilder() {
        this.bwmModel = new BwmModel();
    }

    @Override
    public void setSequence(List<String> sequence) {
        this.bwmModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bwmModel;
    }
}
