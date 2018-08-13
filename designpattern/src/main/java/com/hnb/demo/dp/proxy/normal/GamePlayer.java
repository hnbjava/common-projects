package com.hnb.demo.dp.proxy.normal;

import com.hnb.demo.dp.proxy.IGamePlayer;

/**
 * @author xiaolu
 * @date 2018/8/13 上午11:04
 */
public class GamePlayer implements IGamePlayer {

    private String userName;

    public GamePlayer(IGamePlayer gamePlayer, String userName) throws Exception {
        if (gamePlayer == null) {
            throw new Exception("不能创建真实角色！");
        } else {
            this.userName = userName;
        }
    }

    @Override
    public void login(String userName, String password) {
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
