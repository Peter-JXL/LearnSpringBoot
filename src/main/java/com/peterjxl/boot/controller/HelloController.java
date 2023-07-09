package com.peterjxl.boot.controller;

import com.peterjxl.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController = @Controller + @ResponseBody
@Slf4j
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String hello() {
        log.info("请求进来了...");
        return "你好, Spring Boot 2!";
    }

    @RequestMapping("/1.jpg")
    public String img() {
        return "图片";
    }
}
