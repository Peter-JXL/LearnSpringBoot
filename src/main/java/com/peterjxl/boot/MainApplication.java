package com.peterjxl.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * @SpringBootApplication 这是一个SpringBoot应用程序
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        String[] beanNamesForType = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("beanNamesForType: " + beanNamesForType.length);
    }
}
