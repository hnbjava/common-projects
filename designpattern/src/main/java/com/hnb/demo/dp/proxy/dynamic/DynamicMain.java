package com.hnb.demo.dp.proxy.dynamic;

import com.hnb.demo.dp.proxy.IGamePlayer;
import com.hnb.demo.dp.proxy.base.GamePlayer;
import com.hnb.demo.dp.proxy.dynamic.subject.RealSubject;
import com.hnb.demo.dp.proxy.dynamic.subject.Subject;

import java.lang.reflect.InvocationHandler;

/**
 * @author xiaolu
 * @date 2018/8/13 下午5:52
 */
public class DynamicMain {
    public static void main(String[] args) {
        //定义主题
        Subject subject = new RealSubject();

        //定义handler
        InvocationHandler handler = new SubjectInvocationHandler(subject);

        //定义主题代理
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),handler);

        //代理的行为
        proxy.doSomeThing("ssss");

        IGamePlayer gamePlayer = new GamePlayer();

        //定义handler
        InvocationHandler gameHandler = new SubjectInvocationHandler(gamePlayer);

        //定义主题代理
        IGamePlayer gameProxy = DynamicProxy.newProxyInstance(gamePlayer.getClass().getClassLoader(),
                gamePlayer.getClass().getInterfaces(),gameHandler);

        gameProxy.login("SB","SB");
        gameProxy.killBoss();
        gameProxy.upgrade();




    }
}
