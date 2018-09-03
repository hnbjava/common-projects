package com.hnb.demo.springboot.conditional;

import com.hnb.demo.springboot.conditional.bean.LinuxListService;
import com.hnb.demo.springboot.conditional.bean.ListService;
import com.hnb.demo.springboot.conditional.bean.MacListService;
import com.hnb.demo.springboot.conditional.bean.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;

/**
 * @author xiaolu
 * @date 2018/8/29 上午10:53
 */

@Component
public class ConditionConfig {

    @Bean
    @Conditional(LinuxCondition.class)// 使用@Conditional注解，符合Linux条件就实例化LinuxListService
    public ListService linuxListService() {
        return new LinuxListService();
    }

    @Bean
    @Conditional(WindowsCondition.class)// 使用@Conditional注解，符合Windows条件就实例化WindowsListService
    public ListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(MacCondition.class)// 使用@Conditional注解，符合Windows条件就实例化WindowsListService
    public ListService macListService() {
        return new MacListService();
    }
}
