package com.hnb.demo.biz.base;

/**
 * @author xiaolu
 * @date 2018/8/30 上午9:46
 */
public class TestFlow extends TestFlowParent {
    private static int c = 0;
    private int d;

    static {
        System.out.println("TestFlow static:" + c);
        System.out.println("TestFlow static:" + a);
    }

    public TestFlow() {
        d = 1;
        System.out.println("TestFlow Constructor b" + d);
        System.out.println("TestFlow Constructor b" + b);
    }

    public static void main(String[] args) {
        TestFlow testFlow = new TestFlow();
    }
}
