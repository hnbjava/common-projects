package com.hnb.demo.dp.proxy.base;

import com.hnb.demo.dp.proxy.IGamePlayer;

/**
 * @author xiaolu
 * @date 2018/8/13 上午11:04
 */
public class GamePlayer implements IGamePlayer {

    private String userName;
    private String password;

    @Override
    public void login(String userName, String password) {
        this.userName = userName;
        this.password = password;
        System.out.println(userName + " login by " + password);
    }

    @Override
    public void killBoss() {
        System.out.println(this.userName + " killBoss");
    }

    @Override
    public void upgrade() {
        System.out.println(this.userName + " upgrade");
    }
}
