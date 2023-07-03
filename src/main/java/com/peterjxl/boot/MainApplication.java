package com.peterjxl.boot;

import ch.qos.logback.core.db.DBHelper;
import com.peterjxl.boot.bean.Pet;
import com.peterjxl.boot.bean.User;
import com.peterjxl.boot.config.MyConfig;
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
    }
}
