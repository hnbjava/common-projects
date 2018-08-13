package com.hnb.demo.dp.proxy;

/**
 * @author xiaolu
 * @date 2018/8/13 上午11:01
 */
public interface IGamePlayer {
    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     */
    public void login(String userName,String password);

    /**
     * 杀怪
     */
    public void killBoss();

    /**
     * 升级
     */
    public void upgrade();
}
