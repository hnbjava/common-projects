package com.hnb.demo.springboot;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xiaolu
 * @date 2018/8/29 上午10:46
 */
@Configuration
public class BeanInitializer {
    @PostConstruct
    public void initMethod() throws Exception {
        System.out.println("initMethod 被执行");
    }
    @PreDestroy
    public void destroyMethod() throws Exception {
        System.out.println("destroyMethod 被执行");
    }
}
