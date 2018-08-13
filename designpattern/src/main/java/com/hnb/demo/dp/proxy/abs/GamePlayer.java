package com.hnb.demo.dp.proxy.abs;

import com.hnb.demo.dp.proxy.IGamePlayer;

/**
 * @author xiaolu
 * @date 2018/8/13 上午11:04
 */
public class GamePlayer implements IAbsGamePlayer {

    private String userName;
    private IAbsGamePlayer proxy;

    public GamePlayer(String userName) {
        this.userName = userName;
    }

    @Override
    public IAbsGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    @Override
    public void login(String userName, String password) {
        if (!this.isProxy()) {
            System.out.println("Use Proxy");
            return;
        }
        System.out.println(userName + " login by " + password);
    }

    @Override
    public void killBoss() {
        if (!this.isProxy()) {
            System.out.println("Use Proxy");
            return;
        }
        System.out.println(this.userName + " killBoss");
    }

    @Override
    public void upgrade() {
        if (!this.isProxy()) {
            System.out.println("Use Proxy");
            return;
        }
        System.out.println(this.userName + " upgrade");
    }

    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        }
        return true;
    }
}
