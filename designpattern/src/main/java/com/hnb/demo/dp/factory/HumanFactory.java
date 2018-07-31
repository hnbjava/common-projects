package com.hnb.demo.dp.factory;

import com.hnb.demo.dp.factory.entity.Human;

/**
 * @author xiaolu
 * @date 2018/7/31 上午9:20
 */
public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        T human = null;
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return human;
    }

    public static  <T extends Human> T staticCreateHuman(Class<T> c) {
        T human = null;
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return human;
    }
}
