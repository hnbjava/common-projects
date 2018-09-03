package com.hnb.demo.springboot;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaolu
 * @date 2018/8/29 上午10:53
 */

@Configuration
public class Config {

    @Conditional(MyCondition.class)
    @Bean
    public String condition() {
        System.err.println("自定义的condition的match方法返回值为true时，才会进入该方法创建bean");
        return "";
    }

    /**
     * 该Abc class位于类路径上时
     */
    @ConditionalOnClass(Abc.class)
    @Bean
    public String abc() {
        System.err.println("ConditionalOnClass true");
        return "";
    }

    /**
     * 存在Abc类的实例时
     */
    @ConditionalOnBean(Abc.class)
    @Bean
    public String bean() {
        System.err.println("ConditionalOnBean is exist");
        return "";
    }

    @ConditionalOnMissingBean(Abc.class)
    @Bean
    public String missBean() {
        System.err.println("ConditionalOnBean is missing");
        return "";
    }

    /**
     * 表达式为true时
     */
    @ConditionalOnExpression(value = "true")
    @Bean
    public String expresssion() {
        System.err.println("expresssion is true");
        return "";
    }

    /**
     * 配置文件属性是否为true
     */
    @ConditionalOnProperty(
            value = {"abc.property"},
            matchIfMissing = false)
    @Bean
    public String property() {
        System.err.println("property is true");
        return "";
    }
}
