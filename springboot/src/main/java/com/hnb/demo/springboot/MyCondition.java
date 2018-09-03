package com.hnb.demo.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xiaolu
 * @date 2018/8/29 上午10:55
 */
public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //判断当前系统是Mac，Windows，Linux
        System.out.println();
        return conditionContext.getEnvironment().getProperty("os.name").contains("Mac");
    }
}
