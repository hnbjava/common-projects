package com.hnb.demo.dp.model;

/**
 * 模版方法模式
 * @author xiaolu
 * @date 2018/8/7 下午3:41
 */
public class ModelMain {
    AbstractHummerModel hummerModel = new HummerH1Model();
    static {
        System.out.println("static");
    }

    public static void main(String[] args) {
        ModelMain modelMain = new ModelMain();
        modelMain.hummerModel.run();
    }
}
