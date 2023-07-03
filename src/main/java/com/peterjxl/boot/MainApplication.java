package com.peterjxl.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * @SpringBootApplication 这是一个SpringBoot应用程序
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件：" + tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件：" + user01);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("容器中hehe组件：" + haha);
        System.out.println("容器中hehe1组件：" + hehe);
    }
}
