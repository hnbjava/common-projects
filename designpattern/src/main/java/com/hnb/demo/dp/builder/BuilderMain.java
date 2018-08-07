package com.hnb.demo.dp.builder;

import com.hnb.demo.dp.builder.model.BenzModel;
import com.hnb.demo.dp.builder.model.CarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * @author xiaolu
 * @date 2018/8/7 下午4:31
 */
public class BuilderMain {
    public static void main(String[] args) {
        CarModel benz = new BenzModel();
        List<String> sequence = new ArrayList<String>();
        sequence.add("engineBoom");
        sequence.add("start");
        sequence.add("stop");
        benz.setSequence(sequence);
        benz.run();
        CarModel bwm = new BenzModel();
        bwm.setSequence(sequence);
        bwm.run();
    }
}
