package com.hnb.demo.dp.strategy;

/**
 * @author xiaolu
 * @date 2018/8/14 上午10:19
 */
public class StrategyMain {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        System.out.println(a + "+" + b + "=" + Calculator.ADD.exec(a, b));
        System.out.println(a + "-" + b + "=" + Calculator.SUB.exec(a, b));
    }
}
