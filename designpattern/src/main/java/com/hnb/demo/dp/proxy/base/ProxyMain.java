package com.hnb.demo.dp.proxy.base;

import com.hnb.demo.dp.proxy.IGamePlayer;

/**
 * 代理模式：provide a surrogate or placeholder for another pbject to control access to it.
 * 为其他对象提供一种代理以控制对这个对象的访问。
 * @author xiaolu
 * @date 2018/8/13 上午11:06
 */
public class ProxyMain {
    public static void main(String[] args) {
        IGamePlayer player1 = new GamePlayer();
        IGamePlayer gamePlayerProxy = new GamePlayerProxy(player1);
        gamePlayerProxy.login("SB", "SB");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();
    }
}
