package com.hnb.demo.dp.builder;

import com.hnb.demo.dp.builder.builder.BenzBuilder;
import com.hnb.demo.dp.builder.builder.BwmBuilder;
import com.hnb.demo.dp.builder.builder.CarBuilder;
import com.hnb.demo.dp.builder.model.BwmModel;
import com.hnb.demo.dp.builder.model.CarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaolu
 * @date 2018/8/7 下午5:41
 */
public class Director {
    private List<String> sequence = new ArrayList<String>();
    private CarBuilder benzBuilder = new BenzBuilder();
    private CarBuilder bwmBuilder = new BwmBuilder();

    public CarModel getABenzModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return this.benzBuilder.getCarModel();
    }

    public CarModel getBBenzModel() {
        this.sequence.clear();
        this.sequence.add("engineBoom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return this.benzBuilder.getCarModel();
    }

    public CarModel getCBwmModel() {
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bwmBuilder.setSequence(this.sequence);
        return this.bwmBuilder.getCarModel();
    }

    public CarModel getDBwmModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.bwmBuilder.setSequence(this.sequence);
        return this.bwmBuilder.getCarModel();
    }

    public static void main(String[] args) {
        Director director = new Director();
        for (int i = 0; i < 10; i++) {
            director.getABenzModel().run();
        }
        for (int i = 0; i < 10; i++) {
            director.getBBenzModel().run();
        }
        for (int i = 0; i < 10; i++) {
            director.getCBwmModel().run();
        }
        for (int i = 0; i < 10; i++) {
            director.getDBwmModel().run();
        }
    }
}
