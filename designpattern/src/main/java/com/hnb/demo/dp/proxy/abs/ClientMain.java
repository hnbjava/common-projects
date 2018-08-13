package com.hnb.demo.dp.proxy.abs;

import com.hnb.demo.dp.proxy.IGamePlayer;

/**
 * @author xiaolu
 * @date 2018/8/13 下午2:40
 */
public class ClientMain {
    public static void main(String[] args) {
        IAbsGamePlayer proxy = new GamePlayer("张三");
        proxy.getProxy();
        proxy.login("SB", "SB");
        proxy.killBoss();
        proxy.upgrade();
    }
}
