package com.hnb.demo.dp.proxy.base;

import com.hnb.demo.dp.proxy.IGamePlayer;

/**
 * @author xiaolu
 * @date 2018/8/13 上午11:05
 */
public class GamePlayerProxy implements IGamePlayer {

    private IGamePlayer gamePlayer;

    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String userName, String password) {
        this.gamePlayer.login(userName, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
