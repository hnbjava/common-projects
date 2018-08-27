package com.hnb.demo.biz.interger;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;              // 将3自动装箱成Integer类型
        int c = 3;
        Integer d = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对象
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
        System.out.println(b == c); // true a自动拆箱成int类型再和c比较
        System.out.println(b == d); // true a自动拆箱成int类型再和c比较

        //超过128的Integer做对比时，值相同并且大于127的两个Integer做==判定时为false
        Integer b1 = 128;
        Integer d1 = 128;
        System.out.println(b1 == d1);
        System.out.println(b1.equals(d1));

        // Error:(19, 19) java: 不兼容的类型: 从double转换到float可能会有损失
        //float f = 3.4;
        float f = 3.4f;

        short s1 = 1;
        //由于1是int类型，因此s1+1运算结果也是int 型，需要强制转换类型才能赋值给short型
        // s1 = s1 + 1;

        //s1+= 1;相当于s1 = (short)(s1 + 1);
        s1 += 1;
    }
}
