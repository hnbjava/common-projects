package com.hnb.demo.springboot;

import com.hnb.demo.springboot.conditional.bean.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xiaolu
 * @date 2018/8/29 上午9:59
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BeanDemo beanDemo;

    @Autowired
    private ListService listService;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext run = application.run(args);
        ListService demo = run.getBean(ListService.class);
        System.out.println(demo.showListCmd());
    }

    @Override
    public void run(String... args) throws Exception {
        beanDemo.hello();
        System.out.println(listService.showListCmd());
    }
}
