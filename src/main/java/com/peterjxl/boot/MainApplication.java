package com.peterjxl.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主程序类
 * @SpringBootApplication 这是一个SpringBoot应用程序
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // 启动SpringBoot应用程序
        SpringApplication.run(MainApplication.class, args);
    }
}
