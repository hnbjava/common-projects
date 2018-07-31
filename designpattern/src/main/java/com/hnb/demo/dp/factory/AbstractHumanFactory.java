package com.hnb.demo.dp.factory;

import com.hnb.demo.dp.factory.entity.Human;

/**
 * @author xiaolu
 * @date 2018/7/31 上午9:20
 */
public abstract class AbstractHumanFactory {
    /**
     * 创建人类
     * @param c
     * @param <T>
     * @return
     */
    public abstract <T extends Human> T createHuman(Class<T> c);
}
