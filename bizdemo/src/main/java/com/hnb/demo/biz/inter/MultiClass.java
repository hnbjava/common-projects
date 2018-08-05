package com.hnb.demo.biz.inter;

/**
 * @author xiaolu
 * @date 2018/8/4 下午12:54
 */
public class MultiClass {
    public static void main(String[] args) {
        Base clz = new A(1);
        clz.func1();
        int val1 = 0;
        int val2 = 0;
        System.out.println(val1++);
        System.out.println(++val2);
        int val3 = 0 + ++val2;
        int val4 = 0 + val2++;
        System.out.println(val3);
        System.out.println(val4);

        int a = 20;
        int b = 19;
        /*
        先运算在赋值；
        1. b先和a作比较，b比a小为假，所以a还是20；
        2. b在自增加1，所以b为20；
        3. 因为三元判断为假，所以c等于自增后的b加a为40；

        */
        int c = b++ >= a ? a++ : a + b;
        System.out.println(a);//结果是：20
        System.out.println(b);//结果是：20
        System.out.println(c);//结果是：40
    }

}

class A extends B {
    private int val;

    public A(int val) {
        super(val);
        this.val = val;
        System.out.println("A VAL CONSTRUCTOR");
    }

    public A() {
        System.out.println("A CONSTRUCTOR");
    }
}

class B extends Base {

    private int valB;

    public B(int valB) {
        this.valB = valB;
        System.out.println("B VAL CONSTRUCTOR");
    }

    public B() {
        System.out.println("B CONSTRUCTOR");
    }

    static {
        System.out.println("B STATIC");
    }

    @Override
    void func1() {
        System.out.println("B FUNC1");
    }
}

class Base {
    static {
        System.out.println("BASE STATIC");
    }

    void func1() {
        System.out.println("BASE FUNC1");
    }
}
