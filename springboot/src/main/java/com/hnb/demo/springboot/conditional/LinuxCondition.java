package com.hnb.demo.springboot.conditional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xiaolu
 * @date 2018/8/29 上午11:08
 */
public class LinuxCondition implements Condition {

    @Autowired
    private Environment env;

    @Value("${os.name}")
    String osName;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        osName = env.getProperty("${os.name}");
        return osName.toLowerCase().contains("linux");
    }
}
