package com.hnb.demo.biz.over;

public class OverridingTest {

    public static void main(String[] args) {
        OverridingTest test = new OverridingTest();
        test.getData(null,2);
        test.getData(null, 2,3);
        test.getData(null, new Object[]{1});
//        test.getData(1, 2, 3);
//        test.getData(1, 2, 3, 4);
    }

    public void getData(Object a,Object... s) {
        System.out.println("getData(Object... a)");
    }

    public void getData(String a,Object n, Object... s) {
        System.out.println("getData(int a)");
    }

//    public void getData(int a, int b, Object... s) {
//        System.out.println("getData(int a, int b)");
//    }
//
//    public void getData(int a, int b, int c, Object... s) {
//        System.out.println("getData(int a, int b, int c)");
//    }
}
