package com.hnb.demo.dp.proxy.dynamic.advice;

/**
 * @author xiaolu
 * @date 2018/8/13 下午5:49
 */
public class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        System.out.println("Before Advice");
    }
}
