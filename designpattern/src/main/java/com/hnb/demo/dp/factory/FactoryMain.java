package com.hnb.demo.dp.factory;

import com.hnb.demo.dp.factory.entity.BlackHuman;
import com.hnb.demo.dp.factory.entity.Human;
import com.hnb.demo.dp.factory.entity.WhiteHuman;
import com.hnb.demo.dp.factory.entity.YellowHuman;

/**
 * 工厂模式：
 * 
 *
 * @author xiaolu
 * @date 2018/7/31 上午9:31
 */
public class FactoryMain {
    public static void main(String[] args) {
        System.out.println("<<======BASE PATTERN======>>");
        basePattern();
        System.out.println("<<======SIMPLE PATTERN======>>");
        simplePattern();
    }

    private static void basePattern() {
        AbstractHumanFactory humanFactory = new HumanFactory();
        System.out.println("WHITE PEOPLE");
        Human whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        System.out.println("WHITE PEOPLE COLOR:" + whiteHuman.getColor());
        System.out.println("WHITE PEOPLE TALK:" + whiteHuman.talk());

        System.out.println("WHITE PEOPLE");
        Human blackHuman = humanFactory.createHuman(BlackHuman.class);
        System.out.println("WHITE PEOPLE COLOR:" + blackHuman.getColor());
        System.out.println("WHITE PEOPLE TALK:" + blackHuman.talk());

        System.out.println("WHITE PEOPLE");
        Human yellowHuman = humanFactory.createHuman(YellowHuman.class);
        System.out.println("WHITE PEOPLE COLOR:" + yellowHuman.getColor());
        System.out.println("WHITE PEOPLE TALK:" + yellowHuman.talk());
    }

    private static void simplePattern() {
        System.out.println("WHITE PEOPLE");
        Human whiteHuman = HumanFactory.staticCreateHuman(WhiteHuman.class);
        System.out.println("WHITE PEOPLE COLOR:" + whiteHuman.getColor());
        System.out.println("WHITE PEOPLE TALK:" + whiteHuman.talk());

        System.out.println("WHITE PEOPLE");
        Human blackHuman = HumanFactory.staticCreateHuman(BlackHuman.class);
        System.out.println("WHITE PEOPLE COLOR:" + blackHuman.getColor());
        System.out.println("WHITE PEOPLE TALK:" + blackHuman.talk());

        System.out.println("WHITE PEOPLE");
        Human yellowHuman = HumanFactory.staticCreateHuman(YellowHuman.class);
        System.out.println("WHITE PEOPLE COLOR:" + yellowHuman.getColor());
        System.out.println("WHITE PEOPLE TALK:" + yellowHuman.talk());
    }
}
