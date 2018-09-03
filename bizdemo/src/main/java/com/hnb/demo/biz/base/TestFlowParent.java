package com.hnb.demo.biz.base;

/**
 * @author xiaolu
 * @date 2018/8/30 上午9:46
 */
public class TestFlowParent {
    protected static int a = 0;
    protected int b;

    static {
        System.out.println("TestFlowParent static:" + a);
    }

    public TestFlowParent() {
        b = 1;
        System.out.println("TestFlowParent Constructor b" + b);
    }
}
